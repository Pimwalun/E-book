package com.example.pimwalun.booklist_week10.models

import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by pimwalun on 30/3/2018 AD.
 */
abstract class BookRepository : Observable(){ //ใช้อินเตอเฟสไม่ได้เลยต้องใช้ abstract
    val bookList = ArrayList<Book>()
    abstract fun loadAllBooks() //ประกาศ abstract method
    fun getBooks() : ArrayList<Book>{
        return this.bookList
    }

    fun sortBook(str:String){
        when(str.toLowerCase()){
            "a-z" -> bookList.sortBy { book -> book.title }
            "year" -> bookList.sortBy { book -> book.publicationYear }
        }
        setChanged()
        notifyObservers()
    }

    fun filterBook(str:String):ArrayList<Book>{
        return this.bookList.filter{
            it.title.contains(str , true) ||
                    it.publicationYear.toString().contains(str , true) }
                as ArrayList<Book>
    }
}