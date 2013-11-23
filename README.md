Futuraes
========
##Scala Futures implementation for Google App Engine.


Step 1. Add to your `build.sbt`:


    resolvers += "Scala AppEngine Sbt Repo" at "http://siderakis.github.com/maven"

    libraryDependencies ++= Seq(
      "com.siderakis" %% "futuraes" % "0.1-SNAPSHOT",
      )



Step 2. When using futures always use the provided ExecutionContext by importing `ExecutionContextAE.ImplicitsAE._`:

    import ExecutionContextAE.ImplicitsAE._
  
    override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {
  
      resp.getOutputStream.println("App Engine")
     
      val f1: Future[Traversable[String]] = future((1 to 100).map(a => ("f1:" + a)))
      val f2: Future[Traversable[String]] = future((1 to 100).map(a => ("f2:" + a)))  
  
      f1.foreach(_.foreach(resp.getOutputStream.println))
      f2.foreach(_.foreach(resp.getOutputStream.println))  
  
      Thread.sleep(2000)    
  
    }
  
Step 3. Profit!  *(optional)*
    
  
### Also check out these related scala projects that work great on App Engine:  

[Twirl](https://github.com/spray/twirl) The Play framework Scala template engine, stand-alone and packaged as an SBT plugin

[PlayFramework-AppEngine](https://github.com/siderakis/playframework-appengine) The Play framework Scala routing and MVC, stand-alone and packaged as an SBT plugin.
 
[Play-Json-Standalone](https://github.com/mandubian/play-json-alone) Plays amazing JSON API, as a stand-alone library.
 