package com.bigdatastudy.bean

/**
 * 评论
 * @param comment_id 评论表
 * @param userid 用户id
 * @param p_comment_id 父级评论id（为0是一级评论，不为0则是回复）
 * @param content 评论内容
 * @param addtime 创建时间
 * @param other_id 评论相关的id
 * @param praise_count 点赞数量
 * @param reply_count 回复数量
 */
case class AppComment (var comment_id: Int,
                  var userid: Int,
                  var p_comment_id: Int,
                  var content: String,
                  var addtime: String,
                  var other_id: Int,
                  var praise_count: Int,
                  var reply_count: Int)
