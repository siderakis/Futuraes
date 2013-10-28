import com.google.appengine.api.urlfetch.{HTTPResponse, URLFetchServiceFactory}
import com.google.cloud.sql.jdbc.internal.Url
import java.net.URL
import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import scala.concurrent._
import scala.concurrent.duration._

class FuturaeServlet extends HttpServlet {

  import ExecutionContextAE.ImplicitsAE._

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {

    resp addHeader("Content-Type", "text/plain")
    val outputStream = resp.getOutputStream
    import outputStream.{println => print, close}

    print("Scala Futures on App Engine")

    fallbackDemo()

    promiseDemo()

    urlFetchJavaFutures()

    forComprehensionDemo()

    timeoutDemo()

    traversableOfFuturesDemo()

    futureOfTraversableDemo()

    //At this point all futures have completed.
    close()



    def urlFetchJavaFutures() {
      implicit def f2future[T](f: java.util.concurrent.Future[T]) = future(f.get)

      val ws = URLFetchServiceFactory.getURLFetchService
      // http://engineering.linkedin.com/play/play-framework-linkedin
      val start = System.currentTimeMillis()
      def getLatency(r: Any): Long = System.currentTimeMillis() - start
      print("fetching google")
      val googleTime = ws.fetchAsync(new URL("http://www.google.com")).map(getLatency)
      print("fetching yahoo")
      val yahooTime = ws.fetchAsync(new URL("http://www.yahoo.com")).map(getLatency)
      print("fetching bing")
      val bingTime = ws.fetchAsync(new URL("http://www.bing.com")).map(getLatency)

      Await.ready(Future.sequence(Seq(googleTime, yahooTime, bingTime)).map {
        case times =>
          print(Map("google" -> times(0), "yahoo" -> times(1), "bing" -> times(2)).mkString("(", ", ", ")"))
      }, 3000 millis)
    }

    def fallbackDemo() {
      val f1 = future {
        Thread.sleep(10)
        1 / 0
      }

      val f2 = future {
        Thread.sleep(10)
        "Infinity"
      }

      val f3 = f1 fallbackTo f2

      f3 onSuccess {
        case n => print("1 / 0 = " + n)
      }

      Await.ready(f3, 200 millis)

    }

    def promiseDemo() {
      val p = promise[String]
      val f = p.future
      val producer = future {
        val r = "WORLD"
        p success r
      }
      val consumer = future {
        f onSuccess {
          case r => print("HELLO " + r)
        }
      }

      Await.ready(f, 200 millis)
      Await.ready(producer, 200 millis)
      Await.ready(consumer, 200 millis)

    }

    def forComprehensionDemo() {

      val f = for {
        a ← Future(10 / 2) // 10 / 2 = 5
        b ← Future(a + 1) //  5 + 1 = 6
        c ← Future(a - 1) //  5 - 1 = 4
        if c > 3 // Future.filter
      } yield b * c //  6 * 4 = 24

      print("Blocking for results")
      val result = Await.result(f, 100 millis)
      print(result)

    }

    def timeoutDemo() {

      def fallback[A](default: A, timeout: Duration): Future[A] = future {
        Thread sleep timeout.toMillis
        default
      }

      val timeout = 10 millis

      val tasks = List(30, 12, 18, 6, 25, 10, 11, 80, 5)
      val taskFutures: List[Future[String]] = tasks map {
        ms =>
          val search = future {
            Thread sleep ms
            f"$ms%02d:done"
          }
          Future firstCompletedOf Seq(search, fallback(f"$ms%02d:timeout", timeout))
      }
      val searchFuture: Future[List[String]] = Future sequence taskFutures
      print("Blocking for results")
      val result = Await result(searchFuture, timeout * tasks.length)
      print(result.sorted.mkString("(", ", ", ")"))

    }

    def traversableOfFuturesDemo() {
      // Create 8 futures
      val f1 = Seq[Traversable[Future[String]]](
        (1 to 4).map(a => future("F1:" + a)),
        (1 to 4).map(a => future("F2:" + a))
      )

      // Print out values
      f1.flatten.foreach(_.foreach(print))
      Await.ready(Future.sequence(f1.flatten), 200 millis)

    }

    def futureOfTraversableDemo() {
      // Create 2 futures with 100 values each
      val f2 = Seq[Future[Traversable[String]]](
        future((1 to 10).map(a => "f1:" + a)),
        future((1 to 10).map(a => "f2:" + a))
      )

      // Print out values
      f2.foreach(_.foreach(_.foreach(print)))

      // Wait for futures to finish
      print("Blocking for results")
      Await.ready(Future.sequence(f2), 200 millis)
    }

  }

}

