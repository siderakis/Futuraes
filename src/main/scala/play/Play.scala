//package play
//
//
//package core {
//
//import play.api.mvc.Handler
//
//
//case class Param[T](name: String, value: Either[String, T])
//case class JavascriptReverseRoute(name: String, f: String)
//
//
//object Router {
//  case class HandlerDef(ref: AnyRef, controller: String, method: String, parameterTypes: Seq[Class[_]], verb: String, comments: String, path: String)
//  @scala.annotation.implicitNotFound("Cannot use a method returning ${T} as an Handler")
//  trait HandlerInvoker[T] {
//    def call(call: => T, handler: HandlerDef): Handler
//  }
//  def queryString(items: List[Option[String]]) = {
//    Option(items.filter(_.isDefined).map(_.get).filterNot(_.isEmpty)).filterNot(_.isEmpty).map("?" + _.mkString("&")).getOrElse("")
//  }
//
//  object Route {
//
//  }
//
//  trait Routes {
//
//    def badRequest(error: String): Handler = new Handler{}
//
//    // Action { request =>}
//
//
//    def call(generator: => Handler): Handler = {
//      generator
//    }
//
//    def call[P](pa: Param[P])(generator: (P) => Handler): Handler = {
//      pa.value.fold(badRequest, generator)
//    }
//
//    def call[A1, A2](pa1: Param[A1], pa2: Param[A2])(generator: Function2[A1, A2, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right)
//      yield (a1, a2))
//        .fold(badRequest, { case (a1, a2) => generator(a1, a2) })
//    }
//
//
//    def call[A1, A2, A3](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3])(generator: Function3[A1, A2, A3, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right)
//      yield (a1, a2, a3))
//        .fold(badRequest, { case (a1, a2, a3) => generator(a1, a2, a3) })
//    }
//
//    def call[A1, A2, A3, A4](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4])(generator: Function4[A1, A2, A3, A4, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right)
//      yield (a1, a2, a3, a4))
//        .fold(badRequest, { case (a1, a2, a3, a4) => generator(a1, a2, a3, a4) })
//    }
//
//    def call[A1, A2, A3, A4, A5](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5])(generator: Function5[A1, A2, A3, A4, A5, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right)
//      yield (a1, a2, a3, a4, a5))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5) => generator(a1, a2, a3, a4, a5) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6])(generator: Function6[A1, A2, A3, A4, A5, A6, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right)
//      yield (a1, a2, a3, a4, a5, a6))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6) => generator(a1, a2, a3, a4, a5, a6) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7])(generator: Function7[A1, A2, A3, A4, A5, A6, A7, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7) => generator(a1, a2, a3, a4, a5, a6, a7) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8])(generator: Function8[A1, A2, A3, A4, A5, A6, A7, A8, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8) => generator(a1, a2, a3, a4, a5, a6, a7, a8) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9])(generator: Function9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9], pa10: Param[A10])(generator: Function10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right; a10 <- pa10.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9], pa10: Param[A10], pa11: Param[A11])(generator: Function11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right; a10 <- pa10.value.right; a11 <- pa11.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9], pa10: Param[A10], pa11: Param[A11], pa12: Param[A12])(generator: Function12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right; a10 <- pa10.value.right; a11 <- pa11.value.right; a12 <- pa12.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9], pa10: Param[A10], pa11: Param[A11], pa12: Param[A12], pa13: Param[A13])(generator: Function13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right; a10 <- pa10.value.right; a11 <- pa11.value.right; a12 <- pa12.value.right; a13 <- pa13.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9], pa10: Param[A10], pa11: Param[A11], pa12: Param[A12], pa13: Param[A13], pa14: Param[A14])(generator: Function14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right; a10 <- pa10.value.right; a11 <- pa11.value.right; a12 <- pa12.value.right; a13 <- pa13.value.right; a14 <- pa14.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9], pa10: Param[A10], pa11: Param[A11], pa12: Param[A12], pa13: Param[A13], pa14: Param[A14], pa15: Param[A15])(generator: Function15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right; a10 <- pa10.value.right; a11 <- pa11.value.right; a12 <- pa12.value.right; a13 <- pa13.value.right; a14 <- pa14.value.right; a15 <- pa15.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9], pa10: Param[A10], pa11: Param[A11], pa12: Param[A12], pa13: Param[A13], pa14: Param[A14], pa15: Param[A15], pa16: Param[A16])(generator: Function16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right; a10 <- pa10.value.right; a11 <- pa11.value.right; a12 <- pa12.value.right; a13 <- pa13.value.right; a14 <- pa14.value.right; a15 <- pa15.value.right; a16 <- pa16.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9], pa10: Param[A10], pa11: Param[A11], pa12: Param[A12], pa13: Param[A13], pa14: Param[A14], pa15: Param[A15], pa16: Param[A16], pa17: Param[A17])(generator: Function17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right; a10 <- pa10.value.right; a11 <- pa11.value.right; a12 <- pa12.value.right; a13 <- pa13.value.right; a14 <- pa14.value.right; a15 <- pa15.value.right; a16 <- pa16.value.right; a17 <- pa17.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9], pa10: Param[A10], pa11: Param[A11], pa12: Param[A12], pa13: Param[A13], pa14: Param[A14], pa15: Param[A15], pa16: Param[A16], pa17: Param[A17], pa18: Param[A18])(generator: Function18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right; a10 <- pa10.value.right; a11 <- pa11.value.right; a12 <- pa12.value.right; a13 <- pa13.value.right; a14 <- pa14.value.right; a15 <- pa15.value.right; a16 <- pa16.value.right; a17 <- pa17.value.right; a18 <- pa18.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9], pa10: Param[A10], pa11: Param[A11], pa12: Param[A12], pa13: Param[A13], pa14: Param[A14], pa15: Param[A15], pa16: Param[A16], pa17: Param[A17], pa18: Param[A18], pa19: Param[A19])(generator: Function19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right; a10 <- pa10.value.right; a11 <- pa11.value.right; a12 <- pa12.value.right; a13 <- pa13.value.right; a14 <- pa14.value.right; a15 <- pa15.value.right; a16 <- pa16.value.right; a17 <- pa17.value.right; a18 <- pa18.value.right; a19 <- pa19.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9], pa10: Param[A10], pa11: Param[A11], pa12: Param[A12], pa13: Param[A13], pa14: Param[A14], pa15: Param[A15], pa16: Param[A16], pa17: Param[A17], pa18: Param[A18], pa19: Param[A19], pa20: Param[A20])(generator: Function20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right; a10 <- pa10.value.right; a11 <- pa11.value.right; a12 <- pa12.value.right; a13 <- pa13.value.right; a14 <- pa14.value.right; a15 <- pa15.value.right; a16 <- pa16.value.right; a17 <- pa17.value.right; a18 <- pa18.value.right; a19 <- pa19.value.right; a20 <- pa20.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20) })
//    }
//
//    def call[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](pa1: Param[A1], pa2: Param[A2], pa3: Param[A3], pa4: Param[A4], pa5: Param[A5], pa6: Param[A6], pa7: Param[A7], pa8: Param[A8], pa9: Param[A9], pa10: Param[A10], pa11: Param[A11], pa12: Param[A12], pa13: Param[A13], pa14: Param[A14], pa15: Param[A15], pa16: Param[A16], pa17: Param[A17], pa18: Param[A18], pa19: Param[A19], pa20: Param[A20], pa21: Param[A21])(generator: Function21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Handler]): Handler = {
//      (for (a1 <- pa1.value.right; a2 <- pa2.value.right; a3 <- pa3.value.right; a4 <- pa4.value.right; a5 <- pa5.value.right; a6 <- pa6.value.right; a7 <- pa7.value.right; a8 <- pa8.value.right; a9 <- pa9.value.right; a10 <- pa10.value.right; a11 <- pa11.value.right; a12 <- pa12.value.right; a13 <- pa13.value.right; a14 <- pa14.value.right; a15 <- pa15.value.right; a16 <- pa16.value.right; a17 <- pa17.value.right; a18 <- pa18.value.right; a19 <- pa19.value.right; a20 <- pa20.value.right; a21 <- pa21.value.right)
//      yield (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21))
//        .fold(badRequest, { case (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21) => generator(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21) })
//    }
//
//
//  }
//
//}
//
//package j {
//
//}
//
//}
//
//
//package mvc{
// trait HandlerRef
//}
//package api {
//package mvc {
//
//
//
//object Route {
//
//  trait ParamsExtractor {
//    def unapply(request: RequestHeader): Option[RouteParams]
//  }
//  def apply(method: String, pathPattern: PathPattern) = new ParamsExtractor {
//
//    def unapply(request: RequestHeader): Option[RouteParams] = {
//      if (method == request.method) {
//        pathPattern(request.path).map { groups =>
//          RouteParams(groups, request.queryString)
//        }
//      } else {
//        None
//      }
//    }
//
//  }
//
//}
//import java.util.UUID
//
//
///**
// * Defines a `Call`, which describes an HTTP request and can be used to create links or fill redirect data.
// *
// * These values are usually generated by the reverse router.
// *
// * @param method the request HTTP method
// * @param url the request URL
// */
//case class Call(method: String, url: String)
//trait PathBindable[A] {
//  self =>
//
//  /**
//   * Bind an URL path parameter.
//   *
//   * @param key Parameter key
//   * @param value The value as String (extracted from the URL path)
//   * @return `Right` of the value or `Left` of an error message if the binding failed
//   */
//  def bind(key: String, value: String): Either[String, A]
//
//  /**
//   * Unbind a URL path  parameter.
//   *
//   * @param key Parameter key
//   * @param value Parameter value.
//   */
//  def unbind(key: String, value: A): String
//
//  /**
//   * Javascript function to unbind in the Javascript router.
//   */
//  def javascriptUnbind: String = """function(k,v) {return v}"""
//
//  /**
//   * Transform this PathBinding[A] to PathBinding[B]
//   */
//  def transform[B](toB: A => B, toA: B => A) = new PathBindable[B] {
//    def bind(key: String, value: String): Either[String, B] = self.bind(key, value).right.map(toB)
//    def unbind(key: String, value: B): String = self.unbind(key, toA(value))
//  }
//}
//
//
///**
// * Default binders for URL path part.
// */
//object PathBindable {
//
//  class Parsing[A](parse: String => A, serialize: A => String, error: (String, Exception) => String)//(implicit codec: Codec)
//    extends PathBindable[A] {
//
//    def bind(key: String, value: String): Either[String, A] = {
//      try {
//        Right(parse(value))
//      } catch {
//        case e: Exception => Left(error(key, e))
//      }
//    }
//    def unbind(key: String, value: A): String = serialize(value)
//  }
//
//  /**
//   * Path binder for String.
//   */
//  implicit object bindableString extends Parsing[String](
//    (s: String) => s, (s: String) => s, (key: String, e: Exception) => "Cannot parse parameter %s as String: %s".format(key, e.getMessage)
//  )
//
//  /**
//   * Path binder for Int.
//   */
//  implicit object bindableInt extends Parsing[Int](
//    _.toInt, _.toString, (key: String, e: Exception) => "Cannot parse parameter %s as Int: %s".format(key, e.getMessage)
//  )
//
//  /**
//   * Path binder for Java Integer.
//   */
//  implicit def bindableJavaInteger: PathBindable[java.lang.Integer] =
//    bindableInt.transform(i => i, i => i)
//
//  /**
//   * Path binder for Long.
//   */
//  implicit object bindableLong extends Parsing[Long](
//    _.toLong, _.toString, (key: String, e: Exception) => "Cannot parse parameter %s as Long: %s".format(key, e.getMessage)
//  )
//
//  /**
//   * Path binder for Java Long.
//   */
//  implicit def bindableJavaLong: PathBindable[java.lang.Long] =
//    bindableLong.transform(l => l, l => l)
//
//  /**
//   * Path binder for Double.
//   */
//  implicit object bindableDouble extends Parsing[Double](
//    _.toDouble, _.toString, (key: String, e: Exception) => "Cannot parse parameter %s as Double: %s".format(key, e.getMessage)
//  )
//
//  /**
//   * Path binder for Java Double.
//   */
//  implicit def bindableJavaDouble: PathBindable[java.lang.Double] =
//    bindableDouble.transform(d => d, d => d)
//
//  /**
//   * Path binder for Float.
//   */
//  implicit object bindableFloat extends Parsing[Float](
//    _.toFloat, _.toString, (key: String, e: Exception) => "Cannot parse parameter %s as Float: %s".format(key, e.getMessage)
//  )
//
//  /**
//   * Path binder for Java Float.
//   */
//  implicit def bindableJavaFloat: PathBindable[java.lang.Float] =
//    bindableFloat.transform(f => f, f => f)
//
//  /**
//   * Path binder for Boolean.
//   */
//  implicit object bindableBoolean extends Parsing[Boolean](
//    _.trim match {
//      case "true" => true
//      case "false" => false
//      case b => b.toInt match {
//        case 1 => true
//        case 0 => false
//      }
//    }, _.toString,
//    (key: String, e: Exception) => "Cannot parse parameter %s as Boolean: should be true, false, 0 or 1".format(key)
//  ) {
//    override def javascriptUnbind = """function(k,v){return !!v}"""
//  }
//
//  /**
//   * Path binder for Java Boolean.
//   */
//  implicit def bindableJavaBoolean: PathBindable[java.lang.Boolean] =
//    bindableBoolean.transform(b => b, b => b)
//
//  /**
//   * Path binder for java.util.UUID.
//   */
//  implicit object bindableUUID extends Parsing[UUID](
//    UUID.fromString(_), _.toString, (key: String, e: Exception) => "Cannot parse parameter %s as UUID: %s".format(key, e.getMessage)
//  )
//
//
//}
//
///**
// * An Handler handles a request.
// */
//trait Handler
///**
// * Reference to an Handler.
// */
//class HandlerRef[T](callValue: => T, handlerDef: play.core.Router.HandlerDef)(implicit handlerInvoker: play.core.Router.HandlerInvoker[T]) extends play.mvc.HandlerRef {
//
//  /**
//   * Retrieve a real handler behind this ref.
//   */
//  def handler: play.api.mvc.Handler = {
//    handlerInvoker.call(callValue, handlerDef)
//  }
//
//  /**
//   * String representation of this Handler.
//   */
//  lazy val sym = {
//    handlerDef.controller + "." + handlerDef.method + "(" + handlerDef.parameterTypes.map(_.getName).mkString(", ") + ")"
//  }
//
//  override def toString = {
//    "HandlerRef[" + sym + ")]"
//  }
//
//}
//}
//
//}