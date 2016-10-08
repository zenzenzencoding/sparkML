/**
  * Author : zen.
  * Date: 2016/7/17.
  * Version :
  * Description:向量标签的使用
  */
import org.apache.spark.mllib.linalg.{Vector,Vectors}
import org.apache.spark.mllib.regression.LabeledPoint
object testLabeledPoint {
  def main(args: Array[String]) {
    val vd : Vector = Vectors.dense(2,3,6) //建立密集型向量
    val pos = LabeledPoint(1,vd) //打标签
    println(pos.features) //打印特征
    println(pos.label) //打印标签

    val vs:Vector = Vectors.sparse(4,Array(0,1,3),Array(1,3,5))
    val neg = LabeledPoint(0,vs)
    println(neg.features)
    println(neg.label)
  }
}
