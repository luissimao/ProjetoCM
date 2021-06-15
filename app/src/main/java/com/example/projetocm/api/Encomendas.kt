package com.example.projetocm.api

import java.util.*

data class Encomendas(
    val id: Int,
    val nomeCliente: String,
    val data: String,
    val artigoNome: String,
    val qtd: Int,
    val levantarLoja: String,
    val descricao: String,
    val precoTotal: Float
)
