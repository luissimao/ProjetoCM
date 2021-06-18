package com.example.projetocm

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.projetocm.api.Encomendas
import com.example.projetocm.api.EndPoints
import com.example.projetocm.api.ServiceBuilder
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.models.name
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.String.format
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class CarrinhoCompras: AppCompatActivity() {
    private val client = ChatClient.instance()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_carrinho_compras)

        //Variables
        val username = client.getCurrentUser()?.name
        val price = findViewById<TextView>(R.id.priceTotal)

        //val levantarLoja = findViewById<RadioGroup>(R.id.radioButton)
        val levantarLoja = "Sim"
        val precoTotal = intent.getStringExtra("price").toString()
        val description = findViewById<EditText>(R.id.reservaDesc).text.toString()
        val dateVar = LocalDate.now().toString()

        //Imprimir para o ecrã
        price.setText(precoTotal)

        //Button para reserva
        val reserva = findViewById<Button>(R.id.buttonAdd)
        reserva.setOnClickListener {
            val request = ServiceBuilder.buildService(EndPoints::class.java)
            val call = request.createEncomenda(username, dateVar, "price", 5, levantarLoja.toString(),
                    description, precoTotal.toFloat())

            call.enqueue(object : Callback<Encomendas> {
                override fun onResponse(call: Call<Encomendas>, response: Response<Encomendas>) {
                    if(response.isSuccessful) {
                        val r: Encomendas = response.body()!!
                        Toast.makeText(this@CarrinhoCompras, getString(R.string.toast_11), Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<Encomendas>, t: Throwable) {
                    Toast.makeText(this@CarrinhoCompras, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}