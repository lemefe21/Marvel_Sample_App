package com.leme.marvel.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.leme.marvel.R
import com.leme.marvel.data.remote.getMarvelService
import com.leme.marvel.model.Resource
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    fun getData() {
        val service = getMarvelService()
        val callback = service.getCharacters()

        callback.enqueue(object : Callback<Resource> {
            override fun onFailure(call: Call<Resource>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Resource>, response: Response<Resource>) {
                text_view.text = response.body().toString()
            }
        })
    }
}