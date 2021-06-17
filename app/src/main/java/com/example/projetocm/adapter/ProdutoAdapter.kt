package com.example.projetocm.adapter

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.recyclerview.widget.RecyclerView
import com.example.projetocm.*
import com.example.projetocm.api.Produtos
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.models.name
import java.time.LocalDate


class ProdutoAdapter(val produtos: List<Produtos>, val callbackInterface: CallbackInterface):
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    var price: Float = 0.0F
    lateinit var produtoAdd: String
    private val client = ChatClient.instance()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recycler_product_line, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produtos = produtos[position]

        holder.view.findViewById<TextView>(R.id.name_content).text = produtos.titulo
        holder.view.findViewById<TextView>(R.id.categoria_content).text = produtos.categoria
        holder.view.findViewById<TextView>(R.id.price_content).text = produtos.preco.toString()
        //findViewById<TextView>(R.id.qtd)

        //Data
        //val dateVar = LocalDate.now().toString()

        holder.view.findViewById<Button>(R.id.btn_add).setOnClickListener {
            val context = holder.view.context

            price = (price + produtos.preco)
            produtoAdd = produtos.titulo
            val username = client.getCurrentUser()?.name
            callbackInterface.passResultCallback(price.toString())

            Toast.makeText(context, "$username: $produtoAdd = $price", Toast.LENGTH_LONG).show()
        }

    }

    override fun getItemCount() = produtos.size

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

    interface CallbackInterface{
        fun passResultCallback(price: String)
    }
}

