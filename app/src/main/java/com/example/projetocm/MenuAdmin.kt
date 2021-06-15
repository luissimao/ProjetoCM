package com.example.projetocm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projetocm.databinding.FragmentMenuAdminBinding
import com.example.projetocm.model.ChatUser

class MenuAdmin : Fragment() {

    private var _binding: FragmentMenuAdminBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuAdminBinding.inflate(inflater, container, false)

        //Toolbar
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.messengerButton.setOnClickListener {

            val firstName = "Admin"
            val username = "Admin"

            val chatUser = ChatUser(firstName, username)
            val action = MenuAdminDirections.actionMenuAdminToChannelFragment(chatUser)
            findNavController().navigate(action)

        }

        binding.reservasButton.setOnClickListener {
            val action = MenuAdminDirections.actionMenuAdminToListarReservas()
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}