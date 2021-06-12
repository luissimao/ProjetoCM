package com.example.projetocm.api

import retrofit2.Call
import retrofit2.http.*

interface EndPoints {

    @GET("produto")
    fun getProdutos(): Call<List<Produtos>>

    @GET("produto/{id}")
    fun getProdutosPorId(@Path("id") id: Int): Call<Produtos>

    @FormUrlEncoded
    @POST("eliminarProduto")
    fun deleteProduto(@Field("id") id: Int?): Call<OutputPost>

    @FormUrlEncoded
    @POST("alterarProduto")
    fun updateProduto(@Field("id") id: String?, @Field("titulo") titulo: String?,
                  @Field("preco") preco: String?,
                      @Field("categoria") categoria: String?,
                  @Field("stock") stock: String?): Call<OutputPost>

}