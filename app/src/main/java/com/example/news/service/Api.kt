package com.example.news.service

import com.example.news.models.News
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface Api {
    @GET("top-headlines?apiKey=0b4f059ef3eb42329c797d06381bf6db")
    fun getHeadlines(@Query("country") country: String): Call<News>
}
