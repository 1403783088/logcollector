package com.bigdatastudy.bean

/**
 * 启动日志
 * @param entry 入口： push=1, widget=2, icon=3, notification=4, lockscreen_widget=5
 * @param open_ad_type 开屏广告类型：开屏原生广告=1，开屏插屏广告=2
 * @param action 状态：成功=1，失败=2
 * @param loading_time 加载时长：计算下拉开始到接口返回数据的时间，（开始加载报0，加载成功或加载失败才上报时间）
 * @param detail 失败码（没有则上报空）
 * @param extend1 失败的message（没有则上报空）
 * @param en //启动日志类型标记
 */
case class AppStart(var entry: String,
                    var open_ad_type: String,
                    var action: String,
                    var loading_time: String,
                    var detail: String,
                    var extend1: String,
                    var en: String)


