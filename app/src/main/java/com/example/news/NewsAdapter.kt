package com.example.news

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.news.models.Articles

class NewsAdapter (val context: Context,val articles: List<Articles>):
    Adapter<NewsAdapter.ArticleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articles = articles[position]
        holder.title.text=articles.title
        holder.description.text=articles.description
        Glide.with(context).load(articles.urlToImage).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return articles.size

    }
    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView=itemView.findViewById<ImageView>(R.id.imageView)
        var title=itemView.findViewById<TextView>(R.id.title)
        var description=itemView.findViewById<TextView>(R.id.description)

    }

}