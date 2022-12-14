package com.example.selectimage

import java.io.Serializable

data class Model(
    var image:Int,
    var select:Boolean = true
): Serializable
