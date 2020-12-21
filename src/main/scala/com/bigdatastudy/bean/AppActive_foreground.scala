package com.bigdatastudy.bean

/**
 * 用户前台活跃
 * @param push_id 推送消息的id，如果不是从推送消息打开，传空
 * @param access 1.push 2.icon 3.其他
 */
case class AppActive_foreground(var push_id: String, var access: String)
