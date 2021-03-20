package com.example.news

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news.models.News
import com.example.news.service.Client
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.nio.file.Files.find


class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()

    }

    private fun getNews() {
        val news: Call<News> = Client.instance.getHeadlines("in")
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    Log.d("nikunj", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles)
                    recycler_view.adapter = adapter
                    recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)


                }

            }

            override fun onFailure(call: Call<News>, t: Throwable) {

                Log.d("nikunj", "error in fetching", t)

            }
        })

    }
}