package com.app.fringale.StaticModels

import android.widget.ImageView

class ViewPagerAdapterModel {
    var imageview:Int?=null
    var title1:String?=null
    var title2:String?=null

    constructor(imageview: Int?, title1: String?, title2: String?) {
        this.imageview = imageview
        this.title1 = title1
        this.title2 = title2
    }

}