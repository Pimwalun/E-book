package com.example.pimwalun.booklist_week10.presenter

import com.example.pimwalun.booklist_week10.models.BookRepository
import java.util.*

/**
 * Created by pimwalun on 30/3/2018 AD.
 */
class BookPresenter(val view: BookView,
                    val repository: BookRepository): Observer{
    fun star(){
        repository.addObserver(this)
        repository.loadAllBooks()
    }
    override fun update(obj: Observable?, arg: Any?) { //เวลามีคนมาnotifyจะเรียนmethodนี้
        if(obj == repository){
            view.setBookList(repository.getBooks())
        }
    }
}