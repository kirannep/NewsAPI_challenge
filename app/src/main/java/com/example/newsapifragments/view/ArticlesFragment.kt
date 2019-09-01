package com.example.newsapifragments.view


import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
        val newsRequest = RetrofitInstance().retrofitInstance.create(GetNewsRequest::class.java)
        val call : Call<Results> = newsRequest.getnewsrequest(Constants.COUNTRY_CODE,Constants.API_KEY)
        call.enqueue(object: Callback<Results>{
            override fun onFailure(call: Call<Results>, t: Throwable) {
                Log.i("errormsg",t.message)
            }

            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                val res = response.body()
                Log.i("success",res!!.articles[1].title)
                presenter.getTitle(res)
            }

        })
    }

    override fun displayTitle(title: String) {
        tv_test.text = title
    }

    override fun displayDescription(description: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayUrl(newsurl: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
