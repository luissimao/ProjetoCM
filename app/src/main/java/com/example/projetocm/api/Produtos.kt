package com.example.projetocm.api

data class Produtos (
    val id: Int,
    val titulo: String,
    val preco: Float,
    val categoria: String,
    val stock: Int
)
