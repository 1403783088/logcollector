package com.bigdatastudy.bean

/**
 * 公共日志
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
 */

case class AppBase(var mid: String,
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
                   var la: String)
