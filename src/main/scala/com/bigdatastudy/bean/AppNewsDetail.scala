package com.bigdatastudy.bean

/**
 * 商品详情页
 * @param entry 页面入口来源：应用首页=1，push=2，详情页相关推荐=3
 * @param action 动作：开始加载=1，加载成功=2，加载失败=3，推出页面=4
 * @param goodsid 商品id
 * @param show_style 商品样式：0无图，1一张大图，2两张图，3三张小图，4一张小图，5一张大图两张小图
 * @param news_staytime 页面停留时长：从商品开始加载时开始计算，到用户关闭页面所用的时间。若途中跳转到其他页面了，则暂停计时，待回到
 *                      详情页时恢复计时。或中途划出的时间超过10分钟，则本次计时作废，不上报本次数据。如未加载成功退出则报空
 * @param loading_time 加载时长，计算页面开始加载到接口返回数据的时间（开始加载报0，加载成功或加载失败才上报时间）
 * @param type1 加载失败码：把加载失败状态码报回来（报空为加载成功，没有失败）
 * @param category 分类ID
 */
case class AppNewsDetail(var entry: String,
                         var action: String,
                         var goodsid: String,
                         var show_style: String,
                         var news_staytime: String,
                         var loading_time: String,
                         var type1: String,
                         var category: String)

