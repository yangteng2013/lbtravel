package com.lymobility.shanglv.data.bean

import com.lymobility.shanglv.data.remote.BaseBean

data class ArticleData(var data:List<Chapters> = arrayListOf()) : BaseBean()

class Chapters{
    //    children: []
//    courseId: 13
//    id: 408
//    name: "鸿洋"
//    order: 190000
//    parentChapterId: 407
//    userControlSetTop: false
//    visible: 1
    var courseId = ""
    var id = ""
    var name =  ""
    var order = 0
}
