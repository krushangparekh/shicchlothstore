package com.example.ClothsStore.userModel

import java.io.Serializable

class ShowAllModel : Serializable {
    var description: String? = null
    var name: String? = null
    var rating: String? = null
    var price = 0
    var img_url: String? = null
    var type: String? = null

    constructor() {}
    constructor(
        description: String?,
        name: String?,
        rating: String?,
        price: Int,
        img_url: String?,
        type: String?
    ) {
        this.description = description
        this.name = name
        this.rating = rating
        this.price = price
        this.img_url = img_url
        this.type = type
    }
}