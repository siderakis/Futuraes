import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import scala.concurrent._
import scala.concurrent.duration._

import play.api.mvc.{RequestHeader, Handler, Action, HttpRequest}

class FuturaeServlet extends HttpServlet {

  import ExecutionContextAE.ImplicitsAE._

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {


    if (!req.getRequestURI.contains("fav"))

      (Routes.routes orElse PartialFunction[RequestHeader, Handler] {
        _ => new Handler {
          resp.getOutputStream.println("404")
        }
      })(HttpRequest(req))


  }
}