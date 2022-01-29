package com.hugofmartin.ubereatreprod.data

data class Restaurant (
    var title: String,
    var location: String,
    var sponsored: Boolean,
    var photo:  Int,
    var rating: String,
    var delivery_time: String,
    var hasPromotion: Boolean
    )