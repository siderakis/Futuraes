import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import scala.concurrent._

class FuturaeServlet extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {

    val f: Future[List[String]] = future {
      List("a", "b", "c")
    }(ExecutionContext.global)

    f.map(_.foreach(resp.getOutputStream.println))
  }
}
