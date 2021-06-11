package com.example.projetocm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetocm.databinding.FragmentListarProdutosBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ListarProdutos : Fragment() {

    private var _binding: FragmentListarProdutosBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListarProdutosBinding.inflate(inflater, container, false)

        //val recyclerView = requireView().findViewById<RecyclerView>(R.id.recyclerViewProductList)
        //recyclerView.setHasFixedSize(true)

        /*binding.messengerButton.setOnClickListener {

            val firstName = "Admin"
            val username = "Admin"

            val chatUser = ChatUser(firstName, username)
            val action = MenuAdminDirections.actionMenuAdminToChannelFragment(chatUser)
            findNavController().navigate(action)

        }*/

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}