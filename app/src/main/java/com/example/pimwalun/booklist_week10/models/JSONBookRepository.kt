package com.example.pimwalun.booklist_week10.models

import java.net.URL
import android.os.AsyncTask
import org.json.JSONArray


/**
 * Created by pimwalun on 30/3/2018 AD.
 */
class JSONBookRepository: BookRepository() {

    override fun loadAllBooks() {
        bookList.clear()
        val task = JSONBookLoader()
        task.execute()
    }

    inner class JSONBookLoader: AsyncTask<String, String, String>(){
        override fun doInBackground(vararg p0: String?): String {
            return URL("https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json").readText()
        }

        override fun onPostExecute(result: String?) {
            if(result!=null){
                var data = JSONArray(result)

                for(i in 0..(data.length()-1)){
                    var temp = data.getJSONObject(i)
                    var books = Book( temp.getString("id").toInt() , temp.get("title").toString()
                            , temp.getString("price").toDouble()  , temp.getString("pub_year").toInt()
                            , temp.getString("img_url").toString())
                    bookList.add(books)
                }
                setChanged()
                notifyObservers()
            }
        }
    }
}