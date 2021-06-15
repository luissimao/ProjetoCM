package com.example.projetocm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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

        //Toolbar
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
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
                    }
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