package sparkService.apiFuntions

object sparkProcess {
  def sparkSubmit(id:String):String= {
    val json_path = "/bi/model/" + id + ".json"
    //    System.setProperty("hadoop.home.dir", "D:\\download\\分布式工具\\hadoop\\hadoop-common-2.2.0-bin")
    //    val fs = FileSystem.get(uri,conf,"root")
    //    if(fileSystem.exists(new Path(json_path))){
    if(id.length > 4){
      val rt = Runtime.getRuntime()
      val absPath = System.getProperty("user.dir")
      rt.exec(s"spark-submit --master spark://devmaster1:7077 --name ${id} --total-executor-cores 1 --executor-memory 512M --class sparkprocess ${absPath}/qmtec-peony-1.0-SNAPSHOT.jar ${id}")
      println(s"已执行 ${id}")
      s"已执行 ${id}"
    } else {
      println(s"无 ${id} 这个id")
      s"${id} 错误"
    }
  }
}
