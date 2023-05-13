package com.example.app_lab002

class DataClass {
    var dataTitle:String? = null
    var dataDesc:String? = null
    var dataPrice:String? = null
    var dataPriority:String? = null
    var dataImage:String? = null

    constructor(dataTitle:String? , dataDesc:String? ,dataPrice:String?, dataPriority:String? , dataImage:String? ){
        this.dataTitle = dataTitle
        this.dataDesc = dataDesc
        this.dataPrice = dataPrice
        this.dataPriority = dataPriority
        this.dataImage = dataImage
    }
    constructor(){

    }
}