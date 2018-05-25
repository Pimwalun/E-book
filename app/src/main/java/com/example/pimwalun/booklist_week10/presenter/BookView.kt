package com.example.pimwalun.booklist_week10.presenter

import com.example.pimwalun.booklist_week10.models.Book

/**
 * Created by pimwalun on 30/3/2018 AD.
 */
interface BookView {
    fun setBookList(books: ArrayList<Book>)
}