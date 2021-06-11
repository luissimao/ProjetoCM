package com.example.projetocm.api

import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {

    @GET("produto")
    fun getProdutos(): Call<List<Produtos>>

}