/**
  * Author : zen.
  * Date: 2016/7/17.
  * Version :
  * Description:
  */

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics

object stat {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName(this.getClass.getName + "#zenwan").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile(".\\src\\main\\resources\\stat.txt")
      .map(_.split(' ').map(_.toDouble)).map(line =>Vectors.dense(line))
    val summary = Statistics.colStats(rdd)
    println(summary.mean)
    println(summary.count)
    println(summary.variance)
    println(summary.max)
    println(summary.min)
    Thread.sleep(1000000)
  }
}
