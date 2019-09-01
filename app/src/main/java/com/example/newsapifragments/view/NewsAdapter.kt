package com.example.newsapifragments.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapifragments.R
import com.example.newsapifragments.model.Results
import kotlinx.android.synthetic.main.cardview.view.*

class NewsAdapter(private val newsmodel:Results):RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false))
    }

    override fun getItemCount(): Int {
        return newsmodel.totalResults
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.title.text = newsmodel.articles[position].title
        holder.desc.text = newsmodel.articles[position].description
    }

}

class NewsViewHolder(view: View):RecyclerView.ViewHolder(view){
    val title = view.tv_title
    val desc = view.tv_desc
}