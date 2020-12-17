package com.bigdatastudy.bean

/**
 * 用户后台活跃
 * @param active_source  1=upgrade,2=download,3=plugin_upgrade
 */
case class AppActive_background(var active_source: String)
