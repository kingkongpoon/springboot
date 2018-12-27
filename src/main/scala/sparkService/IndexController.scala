package sparkService

import java.net.URI
import java.sql.DriverManager
import sparkService.apiFuntions.hiveDriver.hiveFun
import sparkService.apiFuntions.prestoDriver.prestoFun
import sparkService.apiFuntions.sparkProcess.sparkSubmit
import scala.collection.mutable.ArrayBuffer
import sparkService.apiFuntions.hdfsDelete.hdfsDel
import sparkService.apiFuntions.hdfsMkdirs.hdfsMkd
import sparkService.apiFuntions.apiIndex.indexPage
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, ResponseBody, RestController}
import org.springframework.stereotype.Controller

@Controller
@RequestMapping(Array(""))
class IndexController {

  @RequestMapping(Array(""))
  @ResponseBody
  def index():String = {
    indexPage()
  }

  @RequestMapping(Array("/presto"))
  @ResponseBody
  def prestoSql(sql:String):String= {
    prestoFun(sql)
  }

  @RequestMapping(Array("/hive"))
  @ResponseBody
  def hiveSql(sql:String):String= {
    hiveFun(sql)
  }

  @RequestMapping(Array("/spark"))
  @ResponseBody
  def sparkprocess(id:String):String= {
    sparkSubmit(id)
    }

  @RequestMapping(Array("/hdfs/rm"))
  @ResponseBody
  def hdfsDeleteFile(path: String, r: Boolean = false):String = {
    hdfsDel(path,r)
  }

  @RequestMapping(Array("/hdfs/mkdirs"))
  @ResponseBody
  def hdfsMkdir(path: String):String = {
    hdfsMkd(path)
  }
}
