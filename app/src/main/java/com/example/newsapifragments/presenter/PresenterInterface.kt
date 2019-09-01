package com.example.newsapifragments.presenter

import com.example.newsapifragments.model.Results

interface PresenterInterface {

    fun getTitle(result:Results)
    fun getDescription()
    fun getUrl()
}