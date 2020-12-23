package com.bigdatastudy.bean

/**
 * 收藏
 * @param course_id 商品id
 * @param userid 用户id
 * @param add_time 创建时间
 */
case class AppFavorites(var course_id: Int,
                        var userid: Int,
                        var add_time: String)
