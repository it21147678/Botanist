package com.example.app_lab002

var plantList = mutableListOf<Plant>()

val PLANT_ID_EXTRA = "plantExtra"

class Plant (
    var cover: Int,
    var plantname:String,
    var title:String,
    var description:String,
    var id:Int? = plantList.size,
)