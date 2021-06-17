package com.example.projetocm

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
import com.example.projetocm.databinding.FragmentCarrinhoComprasBinding
import com.example.projetocm.databinding.FragmentListarProdutosBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarrinhoCompras : Fragment() {

    private var _binding: FragmentCarrinhoComprasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarrinhoComprasBinding.inflate(inflater, container, false)

        //Toolbar
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

