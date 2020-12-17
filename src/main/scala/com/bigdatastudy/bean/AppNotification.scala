package com.bigdatastudy.bean

/**
 * 消息通知
 * @param action 动作：通知产生=1， 通知弹出=2，通知点击=3，常驻通知展示（不重复上报，一天内只报一次）=4
 * @param notify_type 通知id：预警通知=1，天气预报（早=2，晚=3），常驻=4
 * @param ap_time 客户端弹出时间
 * @param content 备用字段
 */
case class AppNotification(var action: String,
                           var notify_type: String,
                           var ap_time: String,
                           var content: String)
