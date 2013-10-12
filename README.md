Futuraes
========
**Scala Futures Implementation for Google App Engine.**


Servlet:

    import ExecutionContextAE.ImplicitsAE._
  
    override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {
  
      resp.getOutputStream.println("App Engine")
     
      val f1: Future[Traversable[String]] = future((1 to 100).map(a => ("f1:" + a)))
      val f2: Future[Traversable[String]] = future((1 to 100).map(a => ("f2:" + a)))  
  
      f1.foreach(_.foreach(resp.getOutputStream.println))
      f2.foreach(_.foreach(resp.getOutputStream.println))  
  
      Thread.sleep(2000)    
  
    }
  
  
Output:


        curl http://localhost:8080
        App Engine
        f1:1
        f1:2
        f1:3
        f1:4
        f1:5
        f1:6
        f1:7
        f1:8
        f1:9
        f1:10
        f1:11
        f1:12
        f1:13
        f1:14
        f1:15
        f1:16
        f1:17
        f1:18
        f1:19
        f1:20
        f1:21
        f1:22
        f1:23
        f1:24
        f1:25
        f2:1
        f1:26
        f2:2
        f1:27
        ff12::238

        f1:29
        f2:4
        f1:30
        f2:5
        f1:31
        f2:6
        f1:32
        f2:7
        f1:33
        f2:8
        f1:34
        f2:9
        f1:35
        f2:10
        f1:36
        f1:37
        f2:11
        f1:38
        f2:12
        f1:39
        f2:13
        f1:40
        f2:14
        f1:41
        f2:15
        f1:42
        f2:16
        f1:43
        f2:17
        f1:44
        f2:18
        f1:45
        f2:19
        f1:46
        f2:20
        f1:47
        f2:21
        f1:48
        f2:22
        f1:49
        f2:23
        f1:50
        f2:24
        f1:51
        f2:25
        f1:52
        f2:26
        f1:53
        f2:27
        f1:54
        f2:28
        f1:55
        f2:29
        f1:56
        f2:30
        f1:57
        f2:31
        f1:58
        ff12::5392

        ff21::3630

        ff12::6314

        ff21::3652

        f1:63
        f1:64
        f1:65
        f1:66
        f1:67
        f1:68
        f1:69
        f1:70
        f2:36
        f1:71
        f2:37
        f1:72
        f2:38
        f1:73
        f2:39
        f1:74
        f2:40
        f2:41
        f1:75
        f2:42
        f1:76
        f2:43
        f1:77
        f2:44
        f1:78
        f2:45
        12:46f
        :79
        f2:47
        f1:80
        f2:48
        f1:81
        f2:49
        f1:82
        f2:50
        f2:51
        f1:83
        f2:52
        f1:84
        f2:53
        f1:85
        f2:54
        f1:86
        f2:55
        f1:87
        f2:56
        f1:88
        f2:57
        f1:89
        f2:58
        f1:90
        f2:59
        f1:91
        f2:60
        f2:61
        f1:92
        f2:62
        f1:93
        f2:63
        f1:94
        f1:95
        f2:64
        f2:65
        f1:96
        f2:66
        f1:97
        f2:67
        f1:98
        f2:68
        f1:99
        f2:69
        f1:100
        f2:70
        f2:71
        f2:72
        f2:73
        f2:74
        f2:75
        f2:76
        f2:77
        f2:78
        f2:79
        f2:80
        f2:81
        f2:82
        f2:83
        f2:84
        f2:85
        f2:86
        f2:87
        f2:88
        f2:89
        f2:90
        f2:91
        f2:92
        f2:93
        f2:94
        f2:95
        f2:96
        f2:97
        f2:98
        f2:99
        f2:100