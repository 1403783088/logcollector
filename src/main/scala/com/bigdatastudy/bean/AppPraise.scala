package com.bigdatastudy.bean

/**
 * 点赞
 * @param id  主键id
 * @param userid  用户id
 * @param target_id  点赞的对象id
 * @param praise_type  点赞类型 1问答点赞 2问答评论点赞 3文章点赞数 4评论点赞
 * @param add_time  添加时间
 */
case class AppPraise(var id: Int, var userid: Int, var target_id: Int, var praise_type: Int, var add_time: String)
