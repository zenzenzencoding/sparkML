/**
  * Author : zen.
  * Date: 2016/7/18.
  * Version :
  * Description:
  */
import org.apache.spark.mllib.feature.{IDF,HashingTF}
import org.apache.spark.{SparkContext,SparkConf}
import org.apache.spark.rdd.RDD
object featureSeclection {
   def main(args :Array[String]): Unit ={
     val conf = new SparkConf() .setMaster("local").setAppName("zenwan") //创建环境变量
     val sc = new SparkContext(conf)
     val docRDD :RDD[Seq[String]] = sc.textFile(".\\src\\main\\resources\\seg").map(_.split(" ").toSeq)
     val hashingTF = new HashingTF() //创建TF 实例
     val tf = hashingTF.transform(docRDD).cache() //计算文档tf值
     val idf = new IDF().fit(tf)
     val tf_idf = idf.transform(tf)
     tf_idf.foreach(println)
   }
}
