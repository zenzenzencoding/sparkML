/**
  * Author : zen.
  * Date: 2016/7/17.
  * Version :
  * Description: 读取libsvm 格式的数据
  */
package zencoding.cn
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.Vector
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.mllib.util.MLUtils
import java.util
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.rdd.RDD

object testLabeledPoint2 {
  def main(args: Array[String]) {
    val conf = new SparkConf ()
      .setMaster("local")
      .setAppName(this.getClass.getName + "#zenwan")
    val sc = new SparkContext(conf)
    val mu :RDD[LabeledPoint]= MLUtils.loadLibSVMFile(sc,"./src/main/resources/cod-rna.txt")
    println(mu)
  }
}
