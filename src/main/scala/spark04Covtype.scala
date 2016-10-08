/**
  * Description:
  * Created by zen on 2016/10/8.
  * Version:
  */

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg._
import org.apache.spark.mllib.regression._
import org.apache.spark.mllib.tree.DecisionTree

object spark04Covtype {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf() .setMaster("local").setAppName("zenwan") //创建环境变量
    val sc = new SparkContext(conf)
    val rawData = sc.textFile("E:\\zen\\Documents\\data\\covtype.data")
    val data = rawData.map{
      line =>
        val values = line.split(",").map(_.toDouble)
        val feature = Vectors.dense(values.init)
        val label = values.last-1
        LabeledPoint(label,feature)
    }
    val Array(trainData,cvData,testData) = data.randomSplit(Array(0.8,0.1,0.1))
    trainData.cache()
    cvData.cache()
    testData.cache()
    val model = DecisionTree.trainClassifier(trainData,7,Map[Int,Int](),"gini",4,100)
    val metrics = getMetrics(model,cvData)
    println(metrics.confusionMatrix)
  }
  import org.apache.spark.mllib.evaluation._
  import org.apache.spark.mllib.tree._
  import org.apache.spark.mllib.tree.model.DecisionTreeModel
  import org.apache.spark.rdd._

  def getMetrics(model:DecisionTreeModel,data:RDD[LabeledPoint]):MulticlassMetrics={
    val predictionAndLabels = data.map{
      line => (model.predict(line.features),line.label)
    }
    new MulticlassMetrics(predictionAndLabels)
  }
}
