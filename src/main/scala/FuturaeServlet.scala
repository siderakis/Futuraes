import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import scala.concurrent._
import ExecutionContext.Implicits.global


class FuturaeServlet extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {

    val f: Future[List[String]] = future {
      List("a", "b", "c")
    }

    f.map(_.foreach(resp.getOutputStream.println))
  }
}
