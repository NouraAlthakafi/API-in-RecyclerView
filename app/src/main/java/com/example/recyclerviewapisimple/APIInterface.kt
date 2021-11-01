package com.example.recyclerviewapisimple

import retrofit2.http.GET
import retrofit2.http.Headers

interface APIInterface {
    @Headers("Content-Type: application/json")
    @GET("/people/")
    fun showNames(): retrofit2.Call<ArrayList<namesListItem?>>
}