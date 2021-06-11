package com.example.projetocm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetocm.databinding.FragmentListarProdutosBinding

class ListarProdutos : Fragment() {

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

        //RecyclerView
        binding.recyclerViewProductList.layoutManager = LinearLayoutManager(requireContext())
        //binding.recyclerViewProductList.adapter = usersAdapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}