package com.example.projetocm

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projetocm.databinding.FragmentLoginAdminBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginAdmin : Fragment() {

    private lateinit var auth: FirebaseAuth
    private var _binding: FragmentLoginAdminBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginAdminBinding.inflate(inflater, container, false)

        binding.buttonLoginAdmin.setOnClickListener {

//            val email: EditText = it.findViewById<EditText>(R.id.firstName_editText)
//
//            val email = findViewById(R.id.firstName_editText) as EditText

            val email = "admin@admin.pt"

            val password = "admin123"

            auth = Firebase.auth

            if(email.isNotEmpty() || password.isNotEmpty()){

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                            task ->
                    if(task.isSuccessful){

                        val action = LoginAdminDirections.actionLoginAdminToMenuAdmin()
                        findNavController().navigate(action)

                    }else{
                        Toast.makeText(getActivity(), "O login falhou", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(getActivity(), "Os campos não podem estar vazios", Toast.LENGTH_SHORT).show()
            }

        }

        binding.buttonUtilizador.setOnClickListener {
            val action = LoginAdminDirections.actionLoginAdminToLoginFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}