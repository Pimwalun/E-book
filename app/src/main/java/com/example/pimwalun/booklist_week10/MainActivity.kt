package com.example.pimwalun.booklist_week10

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.pimwalun.booklist_week10.models.Book
import com.example.pimwalun.booklist_week10.models.JSONBookRepository
import com.example.pimwalun.booklist_week10.presenter.BookPresenter
import com.example.pimwalun.booklist_week10.presenter.BookView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BookView {

    lateinit var bookView: BookPresenter
    lateinit var spinners: Spinner
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookView = BookPresenter(this,JSONBookRepository())
        bookView.star()

        searchView(searchview)

        spinners = findViewById(R.id.spinner)
        textView = findViewById(R.id.textView)

        var spinner = arrayOf("Sort A-Z","Sort By Year")
        spinners.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,spinner)
        spinners.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                textView.text = "Select Sort"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                textView.text = spinner.get(p2)
                bookView.repository.sortBook(textView.text.substring(8))
            }
        }
    }

    override fun setBookList(books: ArrayList<Book>) {
        val array = arrayOfNulls<String>(books.size)

        for (i in 0..(books.size-1)) {
            array[i] = books.get(i).toString()
        }
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array)
        listView.adapter = adapter
    }

    private fun searchView(searchview: SearchView) {
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                setBookList(bookView.repository.filterBook(newText))
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                setBookList(bookView.repository.filterBook(query))
                return false
            }

        })
    }
}
