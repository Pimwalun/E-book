package com.example.pimwalun.booklist_week10.models

/**
 * Created by pimwalun on 30/3/2018 AD.
 */
class Book (val id: Int,
            val title: String,
            val price: Double = 0.0,
            val publicationYear: Int = 0,
            val imageURL: String = ""){

    override fun toString(): String {
//        return title
        return "${title} ${price}"
    }

}