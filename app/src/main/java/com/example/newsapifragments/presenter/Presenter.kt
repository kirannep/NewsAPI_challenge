package com.example.newsapifragments.presenter

import com.example.newsapifragments.model.Articles
import com.example.newsapifragments.model.Results
import com.example.newsapifragments.model.Source

class Presenter(_view:ViewInterface) : PresenterInterface {

    val view:ViewInterface = _view
    val result: Results? = null
    val source: Source? = null
    val articlemodel:Articles? = null

    override fun getTitle(result: Results) {
        view.displayTitle(result!!.articles[0].title)
    }

    override fun getDescription() {
        view.displayDescription(result!!.articles[0].description)
    }

    override fun getUrl() {
        view.displayUrl(result!!.articles[0].url)
    }
}