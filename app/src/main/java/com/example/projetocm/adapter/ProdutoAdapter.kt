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


class ProdutoAdapter(val produtos: List<Produtos>): RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recycler_product_line, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produtos = produtos[position]

        holder.view.findViewById<TextView>(R.id.name_content).text = produtos.titulo
        holder.view.findViewById<TextView>(R.id.categoria_content).text = produtos.categoria
        holder.view.findViewById<TextView>(R.id.price_content).text = produtos.preco.toString()

        holder.view.findViewById<Button>(R.id.btn_add).setOnClickListener {
            val context = holder.view.context
            val sharedPref: SharedPreferences = context.getSharedPreferences(
                R.string.preference_file_key.toString(), Context.MODE_PRIVATE)
                with(sharedPref.edit()){
                    putInt(R.string.idSharedPref.toString(), produtos.id)
                    Log.d("Values", "$")
                    commit()
            }

            /*val idProd = sharedPref.getInt(R.string.idSharedPref.toString(), 0)
            Toast.makeText(context, idProd.toString(), Toast.LENGTH_LONG).show()*/
        }

    }

    override fun getItemCount() = produtos.size

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

}