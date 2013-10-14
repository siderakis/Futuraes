import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import scala.concurrent._
import scala.concurrent.duration._
import scala.util.control.NonFatal
import scala.util.{Failure, Success}

class FuturaeServlet extends HttpServlet {


  /** Starts an asynchronous computation and returns a `Future` object with the result of that computation.
    *
    * The result becomes available once the asynchronous computation is completed.
    *
    * @tparam T       the type of the result
    * @param body     the asynchronous computation
    * @param execctx  the execution context on which the future is run
    * @return         the `Future` holding the result of the computation
    */
  def future[T](body: => T)(implicit execctx: ExecutionContext): Future[T] = Future[T](body)


  import ExecutionContextAE.ImplicitsAE._

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {

    resp.getOutputStream.println("App Engine")
    
		// Create 8 futures
    val f1 = Seq[Traversable[Future[String]]](
      (1 to 4).map(a => future("F1:" + a)),
      (1 to 4).map(a => future("F2:" + a))
    )
		
		// Print out values
		f1.flatten.foreach(_.foreach(resp.getOutputStream.println))

		// Create 2 futures with 100 values each
    val f2 = Seq[Future[Traversable[String]]](
      future((1 to 100).map(a => ("f1:" + a))),
      future((1 to 100).map(a => ("f2:" + a)))
    )
		
    // Print out values
		f2.foreach(_.foreach(_.foreach(resp.getOutputStream.println)))

		// Wait before returning. """threads can't "outlive" the request that creates them."""
	  Await.ready(Future.sequence(f1.flatten ++ f2), 100 millis)
		
    resp.getOutputStream.close()

  }
}


package scala.concurrent.impl {


private[concurrent] object Future {

  class PromiseCompletingRunnable[T](body: => T) extends Runnable {
    val promise = new Promise.DefaultPromise[T]()

    override def run() = {
      promise complete {
        try Success(body) catch {
          case NonFatal(e) => Failure(e)
        }
      }
    }
  }

  def apply[T](body: => T)(implicit executor: ExecutionContext): scala.concurrent.Future[T] = {
    val runnable = new PromiseCompletingRunnable(body)
    executor.prepare.execute(runnable)
    runnable.promise.future
  }
}

}