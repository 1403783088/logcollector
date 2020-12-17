package com.bigdatastudy.bean

/**
 * 商品列表
 * @param action 动作：开始加载=1，加载成功=2，加载失败=3
 * @param loading_time 加载时长：计算下拉开始到接口返回数据时间，（开始加载报0，加载成功）
 * @param loading_way 加载类型：1-读取缓存，2-从接口拉新数据 （加载成功才上报加载类型）
 * @param extend1 扩展字段Extend1
 * @param extend2 扩展字段Extend2
 * @param loading_type 加载类型：自动加载=1，用户下拽加载=2，底部加载=3（底部条出发点击底部提示）
 * @param type1 加载失败码：把加载失败状态码报回来（报空为加载成功，没有失败）
 */
case class AppLoading(var action: String,
                      var loading_time: String,
                      var loading_way: String,
                      var extend1: String,
                      var extend2: String,
                      var loading_type: String,
                      var type1: String)
