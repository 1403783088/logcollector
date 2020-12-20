import com.bigdatastudy.bean.AppStart
import org.slf4j.{Logger, LoggerFactory}

import scala.util.Random

object AppMain{
  val logger: Logger = LoggerFactory.getLogger(AppMain.getClass)
  val rand = new Random()

  //设备id
  val s_mid=0
  //用户id
  val s_uid=0
  //商品id
  val s_goodsid=0

  def main(args: Array[String]): Unit = {
    //参数一：控制发送每条的延时时间
    val delay = if(args.length > 0) args(0).toLong else 0L

    //参数二：循环遍历次数
    val loop_len = if(args.length > 1) args(1).toInt else 1000
  }

  def generateLog(delay: Long, loop_len: Int): Unit ={
    for(i <- 0 until loop_len){
      val flag = rand.nextInt(2)
      flag match {
        case 0 =>
          //应用启动
          val appStart = AppStart()

      }
    }
  }
}