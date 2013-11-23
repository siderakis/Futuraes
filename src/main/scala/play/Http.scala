package play.api.mvc

import javax.servlet.http.HttpServletRequest


trait Request extends RequestHeader {
  self =>


}

case class HttpRequest(req: HttpServletRequest) extends RequestHeader {
  def path: String = if (req.getServletPath.isEmpty) req.getPathInfo else req.getServletPath

  def method: String = req.getMethod


  def queryString: Map[String, Seq[String]] = {
    Option(req.getQueryString).map {
      _.split("&").foldLeft(Map[String, Seq[String]]().withDefaultValue(Seq.empty)) {
          (map, pair) =>
            val kv = pair.split("=")
            map.updated(kv(0), map(kv(0)) ++ Seq(kv(1)))
        }
    }.getOrElse(Map())
  }
}

trait RequestHeader {
  /**
   * The URI path.
   */
  def path: String

  /**
   * The HTTP method.
   */
  def method: String

  /**
   * The parsed query string.
   */
  def queryString: Map[String, Seq[String]]

}

/**
 * An Handler handles a request.
 */
trait Handler

/**
 * Reference to an Handler.
 */
class HandlerRef(callValue: => Action, handlerDef: play.core.Router.HandlerDef)(implicit handlerInvoker: play.core.Router.HandlerInvoker) {
  //} extends play.mvc.HandlerRef {


  /**
   * Retrieve a real handler behind this ref.
   */
  def handler: play.api.mvc.Handler = {
    handlerInvoker.call(callValue, handlerDef)
  }

  /**
   * String representation of this Handler.
   */
  lazy val sym = {
    handlerDef.controller + "." + handlerDef.method + "(" + handlerDef.parameterTypes.map(_.getName).mkString(", ") + ")"
  }

  override def toString = {
    "HandlerRef[" + sym + ")]"
  }


}