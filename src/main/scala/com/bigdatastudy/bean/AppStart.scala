package com.bigdatastudy.bean

/**
 * 启动日志
 * @param mid 设备唯一标识
 * @param uid 用户uid
 * @param vc versionCode 程序版本号
 * @param vn versionName 程序版本名
 * @param l 系统语言
 * @param sr 渠道号，应用从哪个渠道来的
 * @param os Android系统版本
 * @param ar 区域
 * @param md 手机型号
 * @param ba 手机品牌
 * @param sv sdkVersion
 * @param g gmail
 * @param hw heightXwidth 屏幕宽高
 * @param t 客户端日志产生时的时间
 * @param nw 网络模式
 * @param ln lng经度
 * @param la lat纬度
 * @param entry 入口： push=1, widget=2, icon=3, notification=4, lockscreen_widget=5
 * @param open_ad_type 开屏广告类型：开屏原生广告=1，开屏插屏广告=2
 * @param action 状态：成功=1，失败=2
 * @param loading_time 加载时长：计算下拉开始到接口返回数据的时间，（开始加载报0，加载成功或加载失败才上报时间）
 * @param detail 失败码（没有则上报空）
 * @param extend1 失败的message（没有则上报空）
 * @param en //启动日志类型标记
 */
case class AppStart(var mid: String,
                    var uid: String,
                    var vc: String,
                    var vn: String,
                    var l: String,
                    var sr: String,
                    var os: String,
                    var ar: String,
                    var md: String,
                    var ba: String,
                    var sv: String,
                    var g: String,
                    var hw: String,
                    var t: String,
                    var nw: String,
                    var ln: String,
                    var la: String,
                    var entry: String,
                    var open_ad_type: String,
                    var action: String,
                    var loading_time: String,
                    var detail: String,
                    var extend1: String,
                    var en: String)


