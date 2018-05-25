package com.example.pimwalun.booklist_week10.models

/**
 * Created by pimwalun on 30/3/2018 AD.
 */
class MockBookRepository : BookRepository() {
    var booklist = ArrayList<Book>()

    override fun loadAllBooks() {
        booklist.clear()
        booklist.add(Book(1, "How to win BNK election", 500.00))
        booklist.add(Book(2, "How to write Android App", 199.00))
        booklist.add(Book(5, "Sleep today", 39.99))
        setChanged()
        notifyObservers()
    }
}