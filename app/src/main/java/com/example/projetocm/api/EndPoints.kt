package com.example.projetocm.api

import retrofit2.Call
import retrofit2.http.*

interface EndPoints {

    //Reservas -------------------------------------------------------------------------------------
    @GET("produto")
    fun getProdutos(): Call<List<Produtos>>

    @GET("produto/{id}")
    fun getProdutosPorId(@Path("id") id: Int): Call<Produtos>

    @FormUrlEncoded
    @POST("eliminarProduto")
    fun deleteProduto(@Field("id") id: Int): Call<OutputPost>

    @FormUrlEncoded
    @POST("alterarProduto")
    fun updateProduto(@Field("id") id: Int, @Field("titulo") titulo: String?,
                  @Field("preco") preco: Float?, @Field("categoria") categoria: String?,
                  @Field("stock") stock: Int?): Call<OutputPost>

    @FormUrlEncoded
    @POST("criarProduto")
    fun createProduto(@Field("titulo") titulo: String?, @Field("preco") preco: String?,
                      @Field("categoria") categoria: String?,
                  @Field("stock") stock: String?): Call<OutputPost>

    //Encomendas -----------------------------------------------------------------------------------
    @GET("encomenda")
    fun getEncomendas(): Call<List<Encomendas>>

}