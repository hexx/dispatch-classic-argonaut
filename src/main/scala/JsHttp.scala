package dispatch.classic.json.argonaut

import dispatch.classic._
import scalaz._, Scalaz._
import _root_.argonaut._, Argonaut._

object JsHttp {
  implicit class JsHandlers(subject: HandlerVerbs) {
    def ># [T](block: String \/ Json => T) = subject >- (Parse.parse(_) |> block)
  }
  implicit def requestToJsHandlers(r: Request) = new JsHandlers(r)
  implicit def stringToJsHandlers(r: String) = new JsHandlers(new Request(r))
}
