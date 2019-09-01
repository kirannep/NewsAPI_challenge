package com.example.newsapifragments.presenter

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapifragments.common.Constants
import com.example.newsapifragments.model.Articles
import com.example.newsapifragments.model.Results
import com.example.newsapifragments.model.Source
import com.example.newsapifragments.network.GetNewsRequest
import com.example.newsapifragments.network.RetrofitInstance
import com.example.newsapifragments.view.NewsAdapter
import kotlinx.android.synthetic.main.fragment_articles.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(_view:ViewInterface) : PresenterInterface {

    val view:ViewInterface = _view
    val result: Results? = null
    val source: Source? = null
    val articlemodel:Articles? = null

    override fun getNewsdetails() {

        val newsRequest = RetrofitInstance().retrofitInstance.create(GetNewsRequest::class.java)
        val call : Call<Results> = newsRequest.getnewsrequest(Constants.COUNTRY_CODE, Constants.API_KEY)
        call.enqueue(object: Callback<Results> {
            override fun onFailure(call: Call<Results>, t: Throwable) {
                Log.i("errormsg",t.message)
            }

            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                val res = response.body()
                Log.i("success",res!!.articles[1].title)
                view.displayNewsInfo(res)
            }

        })
    }
}