package com.example.projetocm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetocm.R
import com.example.projetocm.api.Encomendas

class ReservaAdapter(val encomendas: List<Encomendas>): RecyclerView.Adapter<ReservaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recycler_reserva_line, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val encomendas = encomendas[position]

        holder.view.findViewById<TextView>(R.id.date).text = encomendas.data.toString()
        holder.view.findViewById<TextView>(R.id.client).text = encomendas.nomeCliente
        holder.view.findViewById<TextView>(R.id.artigo).text = encomendas.artigoNome
        holder.view.findViewById<TextView>(R.id.qtd).text = encomendas.qtd.toString()
        holder.view.findViewById<TextView>(R.id.levantarLoja).text = encomendas.levantarLoja
        holder.view.findViewById<TextView>(R.id.description).text = encomendas.descricao
        holder.view.findViewById<TextView>(R.id.price).text = encomendas.precoTotal.toString()
    }

    override fun getItemCount() = encomendas.size

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

}