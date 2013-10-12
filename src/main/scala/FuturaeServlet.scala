import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import scala.concurrent._

class FuturaeServlet extends HttpServlet {

 // import ExecutionContextAE.ImplicitsAE._
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {

    resp.getOutputStream.println("App Engine")
    val f: Future[List[String]] = future {
      List("a", "b", "c")
    }(ExecutionContextAE.global)

    f.map(_.foreach(resp.getOutputStream.println))(ExecutionContextAE.global)


  }


}


