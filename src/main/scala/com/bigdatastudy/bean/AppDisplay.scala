package com.bigdatastudy.bean


/**
 * 商品点击
 * @param action 动作：曝光商品=1，点击商品=2
 * @param goodsid 商品ID（服务端下发的ID）
 * @param place 顺序（第几条商品，第一条为0，第二条为1，以此类推）
 * @param extend1 曝光类型： 1-首次曝光，2-重复曝光
 * @param category 分类ID（服务端定义的分类ID）
 */
case class AppDisplay(var action: String,
                      var goodsid: Int,
                      var place: String,
                      var extend1: String,
                      var category: String)
