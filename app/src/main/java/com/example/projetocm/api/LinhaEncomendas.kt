package com.example.projetocm.api

data class LinhaEncomendas (
    val id: Int,
    val encomendas_id: Int,
    val nomeProd: String,
    val qtd: String,
    val preco: Float
)
