import com.alibaba.fastjson.{JSON, JSONArray, JSONObject}
import com.bigdatastudy.bean.{AppActive_background, AppActive_foreground, AppAd, AppBase, AppDisplay, AppErrorLog, AppLoading, AppNewsDetail, AppNotification, AppStart}
import org.slf4j.{Logger, LoggerFactory}

import scala.util.Random

object AppMain{
  val logger: Logger = LoggerFactory.getLogger(AppMain.getClass)
  val rand = new Random()

  //设备id
  var s_mid=0
  //用户id
  var s_uid=0
  //商品id
  var s_goodsid=0

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
          val appStart: AppStart = generateStart()
          val jsonString = JSON.toJSON(appStart).toString
          //控制台打印
          logger.info(jsonString)

        case 1 =>
          val json: JSONObject = new JSONObject()
          json.fluentPut("ap", "app").put("cm", generateComFiles())

          val eventsArray: JSONArray = new JSONArray()

          //事件日志
          //商品点击，展示
          if(rand.nextBoolean()){
            eventsArray.add(generateDisplay())
            json.put("et", eventsArray)
          }

          //商品详情页
          if(rand.nextBoolean()){
            eventsArray.add(generateNewsDetail())
            json.put("et", eventsArray)
          }

          //商品列表页
          if(rand.nextBoolean()){
            eventsArray.add(generateNewsList())
            json.put("et", eventsArray)
          }

          //广告
          if(rand.nextBoolean()){
            eventsArray.add(generateAd())
            json.put("et", eventsArray)
          }

          //消息通知
          if(rand.nextBoolean()){
            eventsArray.add(generateNotification())
            json.put("et", eventsArray)
          }

          //用户前台活跃
          if(rand.nextBoolean()){
            eventsArray.add(generatebeforeground())
            json.put("et", eventsArray)
          }

          //用户后台活跃
          if(rand.nextBoolean()){
            eventsArray.add(generateBackground())
            json.put("et", eventsArray)
          }

          //故障日志
          if(rand.nextBoolean()){
            eventsArray.add(generateError())
            json.put("et", eventsArray)
          }

          //用户评论
          if(rand.nextBoolean()){
            eventsArray.add(generateComment())
            json.put("et", eventsArray)
          }

          //用户收藏
          if(rand.nextBoolean()){
            eventsArray.add(generateFavorites())
            json.put("et", eventsArray)
          }

          //用户点赞
          if(rand.nextBoolean()){
            eventsArray.add(generatePraise())
            json.put("et", eventsArray)
          }

          //时间
          val millis = System.currentTimeMillis()

          //控制台打印
          logger.info(millis + "|" + json.toJSONString)
      }

      //延迟
      try{
        Thread.sleep(delay)
      }catch{
        case e: InterruptedException =>
          e.printStackTrace()
      }
    }
  }

  /**
   * 公共字段设置
   */
  def generateComFiles(): JSONObject = {
    val appBase = AppBase(
      s_mid+"",
      s_uid+"",
      rand.nextInt(20)+"",
      "1."+rand.nextInt(4)+"."+rand.nextInt(10),
      "8."+rand.nextInt(3)+"."+rand.nextInt(10),
      Seq("es", "en", "pt")(rand.nextInt(3)),
      getRandomChar(1),
      Seq("BR", "MX")(rand.nextInt(2)),
      Seq("Sumsung", "Huawei", "HTC")(rand.nextInt(3)),
      Seq(s"Sumsung${rand.nextInt(20)}", s"Huawei${rand.nextInt(20)}", s"HTC${rand.nextInt(20)}")(rand.nextInt(3)),
      s"V2.${rand.nextInt(10)}.${rand.nextInt(10)}",
      getRandomCharAndNumr(8)+"@gmail.com",
      Seq("640*960", "640*1136", "750*1134", "1080*1920")(rand.nextInt(4)),
      ""+(System.currentTimeMillis()-rand.nextInt(99999999)),
      Seq("3G", "4G", "WIFI")(rand.nextInt(3)),
      ""+(-34 - rand.nextInt(83) - rand.nextInt(60)/10.0),
      ""+(32 - rand.nextInt(85) - rand.nextInt(60)/10.0))
    s_mid+=1
    s_uid+=1
    JSON.toJSON(appBase).asInstanceOf[JSONObject]
  }

  /**
   * 商品展示事件
   */
  def generateDisplay(): JSONObject = {
    s_goodsid+=1
    val appDisplay = AppDisplay(
      Seq("1", "2")(if(rand.nextInt(10)<7) 0 else 1),
      s_goodsid+"",
      rand.nextInt(6)+"",
      (1+rand.nextInt(2))+"",
      (1+rand.nextInt(100))+""
    )
    val jsonObject = JSON.toJSON(appDisplay).asInstanceOf[JSONObject]
    packEventJson("display", jsonObject)
  }

  //商品详情页
  def generateNewsDetail(): JSONObject = {
    val appNewsDetail = AppNewsDetail(
      rand.nextInt(3)+"",
      (rand.nextInt(4)+1)+"",
      s_goodsid+"",
      rand.nextInt(6)+"",
      rand.nextInt(10)*rand.nextInt(7)+"",
      rand.nextInt(10)*rand.nextInt(7)+"",
      Seq("102", "201", "325", "433", "542", "", "", "", "", "")(rand.nextInt(10)),
      (1+rand.nextInt(100))+""
    )
    val eventJson = JSON.toJSON(appNewsDetail).asInstanceOf[JSONObject]
    packEventJson("newsdetail", eventJson)
  }

  //商品列表
  def generateNewsList(): JSONObject = {
    val appLoading = AppLoading(
      (rand.nextInt(3)+1)+"",
      rand.nextInt(10)*rand.nextInt(7)+"",
      1+rand.nextInt(2)+"",
      "",
      "",
      (1+rand.nextInt(3))+"",
      Seq("102", "201", "325", "433", "542", "", "", "", "", "")(rand.nextInt(10))
    )
    val jsonObject = JSON.toJSON(appLoading).asInstanceOf[JSONObject]
    packEventJson("loading", jsonObject)
  }

  /**
   * 广告相关字段
   */
  def generateAd(): JSONObject = {
    val appAd = AppAd(
      (1+rand.nextInt(3))+"",
      (1+rand.nextInt(5))+"",
      (if(rand.nextInt(10)>6) 2 else 1) +"",
      Seq("102", "201", "325", "433", "542", "", "", "", "", "")(rand.nextInt(10)),
      (1+rand.nextInt(4))+"",
      (1+rand.nextInt(2))+"",
      rand.nextInt(10)+"",
      rand.nextInt(6)+""
    )
    val jsonObject = JSON.toJSON(appAd).asInstanceOf[JSONObject]
    packEventJson("ad", jsonObject)
  }

  /**
   * 启动日志
   */
  def generateStart(): AppStart = {
    val appStart = AppStart(
      s_mid+"",
      s_uid+"",
      rand.nextInt(20)+"",
      "1."+rand.nextInt(4)+"."+rand.nextInt(10),
      "8."+rand.nextInt(3)+"."+rand.nextInt(10),
      Seq("es", "en", "pt")(rand.nextInt(3)),
      getRandomChar(1),
      Seq("BR", "MX")(rand.nextInt(2)),
      Seq("Sumsung", "Huawei", "HTC")(rand.nextInt(3)),
      Seq(s"Sumsung${rand.nextInt(20)}", s"Huawei${rand.nextInt(20)}", s"HTC${rand.nextInt(20)}")(rand.nextInt(3)),
      s"V2.${rand.nextInt(10)}.${rand.nextInt(10)}",
      getRandomCharAndNumr(8)+"@gmail.com",
      Seq("640*960", "640*1136", "750*1134", "1080*1920")(rand.nextInt(4)),
      ""+(System.currentTimeMillis()-rand.nextInt(99999999)),
      Seq("3G", "4G", "WIFI")(rand.nextInt(3)),
      ""+(-34 - rand.nextInt(83) - rand.nextInt(60)/10.0),
      ""+(32 - rand.nextInt(85) - rand.nextInt(60)/10.0),
      (rand.nextInt(5)+1)+"",
      (rand.nextInt(2)+1)+"",
      (if(rand.nextInt(10)>8) 2 else 1) +"",
      rand.nextInt(20)+"",
      Seq("102", "201", "325", "433", "542", "", "", "", "", "")(rand.nextInt(10)),
      "",
      "start"
    )
    s_mid+=1
    s_uid+=1
    appStart
  }

  /**
   * 消息通知
   */
  def generateNotification(): JSONObject = {
    val appNotification = AppNotification(
      (rand.nextInt(4)+1)+"",
      (rand.nextInt(4)+1)+"",
      (System.currentTimeMillis() - rand.nextInt(99999999))+"",
      ""
    )
    val jsonObject = JSON.toJSON(appNotification).asInstanceOf[JSONObject]
    packEventJson("notification", jsonObject)
  }

  /**
   * 前台活跃
   */
  def generatebeforeground(): JSONObject = {
    val appActive_foreground = AppActive_foreground(
      Seq("", "1")(rand.nextInt(2)),
      (rand.nextInt(3)+1)+""
    )
    val jsonObject = JSON.toJSON(appActive_foreground).asInstanceOf[JSONObject]
    packEventJson("active_foreground", jsonObject)
  }

  /**
   * 后台活跃
   */
  def generateBackground(): JSONObject = {
    val appActive_background = AppActive_background(
      (rand.nextInt(3)+1)+""
    )
    val jsonObject = JSON.toJSON(appActive_background).asInstanceOf[JSONObject]
    packEventJson("active_background", jsonObject)
  }

  /**
   * 错误日志数据
   */
  def generateError(): JSONObject = {
    val errorBriefs = Seq("at cn.lift.dfdf.web.AbstractBaseController.validInbound(AbstractBaseController.java:72)",
      "at cn.lift.appIn.control.CommandUtil.getInfo(CommandUtil.java:67)")
    val errorDetails = Seq("java.lang.Null.PointerException\\n    "+
      "at cn.lift.appIn.web.AbstractBaseController.validInbound(AbstractBaseController.java:72)\\n " + )
    val appErrorLog = AppErrorLog(

    )
  }

}