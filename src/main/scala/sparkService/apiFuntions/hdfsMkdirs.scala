package sparkService.apiFuntions

import java.net.URI

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem,Path}

object hdfsMkdirs {
  def hdfsMkd(path: String):String = {
    val conf = new Configuration()// 加載配制文件
    val ha_host = "qmyrc"
    val nn1 = "bdmaster1"
    val ip1 = "bdmaster1"
    val nn2 = "bdnode1"
    val ip2 = "bdnode1"
    conf.set("fs.defaultFS", s"hdfs://${ha_host}")
    conf.set("dfs.nameservices", s"${ha_host}")
    conf.set(s"dfs.ha.namenodes.${ha_host}", s"${nn1},${nn2}")
    conf.set(s"dfs.namenode.rpc-address.${ha_host}.${nn1}", s"${ip1}:9000")
    conf.set(s"dfs.namenode.rpc-address.${ha_host}.${nn2}", s"${ip2}:9000")
    conf.set(s"dfs.client.failover.proxy.provider.${ha_host}","org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider")
    val uri = new URI(s"hdfs://${ha_host}/")
    val fs = FileSystem.get(uri,conf,"root")
    fs.mkdirs(new Path(path))
    s"已创建${path}"
  }
}
