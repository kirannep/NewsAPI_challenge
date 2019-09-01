package com.example.newsapifragments.view


import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.newsapifragments.R
import com.example.newsapifragments.common.Constants
import com.example.newsapifragments.model.Articles
import com.example.newsapifragments.model.Results
import com.example.newsapifragments.network.GetNewsRequest
import com.example.newsapifragments.network.RetrofitInstance
import com.example.newsapifragments.presenter.Presenter
import com.example.newsapifragments.presenter.ViewInterface
import kotlinx.android.synthetic.main.fragment_articles.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class ArticlesFragment : Fragment(),ViewInterface {
    private lateinit var presenter:Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = Presenter(this)
        super.onViewCreated(view, savedInstanceState)
        presenter.getNewsdetails()
    }

    override fun displayNewsInfo(results: Results) {
        val adapter: NewsAdapter = NewsAdapter(results)
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = adapter

    }


}
