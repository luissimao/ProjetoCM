package com.example.projetocm

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CarrinhoCompras: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_carrinho_compras)

        //Price
        val price = findViewById<TextView>(R.id.priceTotal)
        //price.setText(priceProd.toString())
    }
}