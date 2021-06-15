package com.example.projetocm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetocm.R
import com.example.projetocm.api.Produtos

class ProdutoAdapter(val produtos: List<Produtos>): RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recycler_product_line, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produtos = produtos[position]
        holder.view.findViewById<TextView>(R.id.name_content).text = produtos.titulo
        holder.view.findViewById<TextView>(R.id.categoria_content).text = produtos.categoria
        holder.view.findViewById<TextView>(R.id.price_content).text = produtos.preco.toString()
    }

    override fun getItemCount() = produtos.size

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

}