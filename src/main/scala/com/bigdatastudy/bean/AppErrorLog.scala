package com.bigdatastudy.bean

/**
 * 错误日志
 * @param errorBrief 错误摘要
 * @param errorDetail 错误详情
 */
case class AppErrorLog(var errorBrief: String, var errorDetail: String)