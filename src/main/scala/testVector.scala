/**
  * Author : zen.
  * Date: 2016/7/17.
  * Version :
  * Description:
  */
import org.apache.spark.mllib.linalg.{Vector,Vectors,Matrices,_}

object testVector {
  /**
    * local vector
    * @param args
    */
  def main(args:Array[String]): Unit ={
    val vd:Vector = Vectors.dense(2,0,6) //建立密集向量
    val mx:Matrix = Matrices.dense(2,3,Array(2,0,6,3,4,5)) //建立密集向量
    val vs:Vector = Vectors.sparse(4,Array(0,2,3),Array(9,2,7))
    println(vd(2))
    println(mx.getClass)
    println(vs.toDense)
  }
}
