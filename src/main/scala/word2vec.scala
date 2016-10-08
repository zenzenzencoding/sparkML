/**
  * Author : zen.
  * Date: 2016/7/19.
  * Version :
  * Description:
  */
import org.apache.spark.mllib.feature.{IDF,HashingTF,Word2Vec}
import org.apache.spark.{SparkContext,SparkConf}
import org.apache.spark.rdd.RDD
object word2vec {
  def main(args: Array[String]) {
    val conf = new SparkConf() .setMaster("local").setAppName("word2vec") //创建环境变量
    val sc = new SparkContext(conf)
    val docRDD = sc.textFile(".\\src\\main\\resources\\seg").map(_.split(" ").toSeq) //读取数据
    val w2v = new Word2Vec()
    val model = w2v.fit(docRDD)
    println(model.getVectors)
    val synonyms = model.findSynonyms("ECNU",2)
    for (word <- synonyms){
      println(word)
    }
  }
}
