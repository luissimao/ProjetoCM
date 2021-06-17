package com.example.projetocm

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetocm.adapter.ProdutoAdapter
import com.example.projetocm.api.EndPoints
import com.example.projetocm.api.Produtos
import com.example.projetocm.api.ServiceBuilder
import com.example.projetocm.databinding.FragmentListarProdutosBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListarProdutos : Fragment() {

    private lateinit var produtos: List<Produtos>
    private var _binding: FragmentListarProdutosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListarProdutosBinding.inflate(inflater, container, false)

        //Variables for Shared Preferences
        val sharedPref: SharedPreferences = this.requireActivity().getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val idProd = sharedPref.getInt(getString(R.string.idSharedPref), 0)
        //val nameProd = sharedPref.getString(getString(R.string.nameSharedPref), "")
        //val qtdProd = sharedPref.getInt(getString(R.string.qtdSharedPref), 0)
        //val priceProd = sharedPref.getFloat(getString(R.string.qtdSharedPref), 0.0F)

        //Toolbar
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.btncarrinho.setOnClickListener{
            val action = ListarProdutosDirections.actionListarProdutosToCarrinhoCompras()
            findNavController().navigate(action)
        }

        val request = ServiceBuilder.buildService(EndPoints::class.java)
        val call = request.getProdutos()
        call.enqueue(object : Callback<List<Produtos>> {
            override fun onResponse(call: Call<List<Produtos>>, response: Response<List<Produtos>>) {
                if(response.isSuccessful) {
                    produtos = response.body()!!
                    produtos?.let {
                        //RecyclerView
                        binding.recyclerViewProductList.layoutManager = LinearLayoutManager(requireContext())
                        binding.recyclerViewProductList.adapter = ProdutoAdapter(produtos)
                        binding.recyclerViewProductList.addItemDecoration(
                            DividerItemDecoration(activity, 1))
                    }
                    //Toast.makeText(activity, nameProd, Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<List<Produtos>>, t: Throwable) {
                Toast.makeText(activity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })

        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

