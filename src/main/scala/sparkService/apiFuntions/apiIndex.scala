package sparkService.apiFuntions

import scala.collection.mutable.ArrayBuffer

object apiIndex {
  def indexPage():String = {
    println("index")
    val title = "<th>api接口</th><th>说明</th>"
    val api_list = ArrayBuffer[String]()
    api_list.append("<td>/presto?sql=show tables</td><td>查presto上的数据</td>")
    api_list.append("<td>/hive?sql=show tables</td><td>查hive上的数据,支持drop table操作</td>")
    api_list.append("<td>/spark?id=100010_10062</td><td>运行spark任务</td>")
    api_list.append("<td>/hdfs/mkdirs?path=/xxxx/xxx/xx/x</td><td>递归生成一个目录</td>")
    api_list.append("<td>/hdfs/rm?path=/xxxx/xxx/xx/x&r=true</td><td>删除hdfs上的文件,默认不递归删除,r?=true时递归删除</td>")
    var print_list = ""
    api_list.foreach( x => print_list += ( "<tr>" + x + "</tr>"))
    """<html><body><table border="1">""" + title + print_list +  "</table></body></html>"
  }
}
