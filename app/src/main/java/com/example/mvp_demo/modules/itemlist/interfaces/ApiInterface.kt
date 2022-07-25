package com.example.mvp_demo.modules.itemlist.interfaces

import com.example.mvp_demo.modules.itemlist.models.Item
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getData(): Call<MutableList<Item>>
}