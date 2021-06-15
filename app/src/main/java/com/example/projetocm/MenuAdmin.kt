package com.example.projetocm

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projetocm.R
import com.example.projetocm.databinding.FragmentLoginAdminBinding
import com.example.projetocm.databinding.FragmentLoginBinding
import com.example.projetocm.databinding.FragmentMenuAdminBinding
import com.example.projetocm.model.ChatUser
import com.example.projetocm.ui.login.LoginFragmentDirections
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

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

//        binding.buttonUtilizador.setOnClickListener {
//            val action = LoginAdminDirections.actionLoginAdminToLoginFragment()
//            findNavController().navigate(action)
//        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}