package com.example.projetocm.api

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface EndPoints {

    @GET("produto")
    fun getProdutos(): Call<List<Produtos>>

    @FormUrlEncoded
    @POST("criarProduto")
    fun addProduto(@Field("titulo") titulo: String,
                  @Field("preco") preco: Float,
                  @Field("categoria") categoria: String,
                  @Field("stock") stock: Int,
    ): Call<Produtos>

    @FormUrlEncoded
    @POST("eliminarProduto")
    fun deleteProduto(@Field("id") id: Int): Call<Produtos>

}