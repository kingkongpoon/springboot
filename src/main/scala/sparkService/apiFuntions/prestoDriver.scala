package sparkService.apiFuntions

import java.sql.DriverManager

object prestoDriver {

  def prestoFun(sql:String):String={
    Class.forName("com.facebook.presto.jdbc.PrestoDriver")
    val connection=DriverManager.getConnection("jdbc:presto://devmaster1:9999/hive/default","hive",null)
    val statement=connection.prepareStatement(sql)
    val rs=statement.executeQuery()
    //获取列数
    val colnums = rs.getMetaData().getColumnCount
    var tittle = ""
    var row = ""
    for(i <- Array.range(1, colnums + 1)){ tittle += "<th>"+rs.getMetaData.getColumnName(i)+"</th>"}
    //      tittle = "<tr>" +tittle + "<tr>"
    while(rs.next()){
      //列索引从1开始
      for(i <- Array.range(1, colnums + 1)){
        row += "<td>"+ s"${rs.getString(i)}" + "</td>"
        //          print(s"${rs.getMetaData.getColumnLabel(i)}:${rs.getString(i)} \t ")
      }
      row = "<tr>" + row + "</tr>"
    }
    """<html><body><table border="1">""" + tittle +  row +  "</table></body></html>"
  }
}
