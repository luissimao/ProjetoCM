package com.example.projetocm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.projetocm.ui.login.LoginFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginAdmin : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_admin)


        val loginButton = findViewById<Button>(R.id.buttonLogin)
        val email = findViewById<EditText>(R.id.email_editText)
        val password = findViewById<EditText>(R.id.password_editText)
        val buttonUtilizador = findViewById<Button>(R.id.buttonUtilizador)

        auth = Firebase.auth

        loginButton.setOnClickListener {

            if(email.text.isNotEmpty() || password.text.isNotEmpty()){

                auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener {
                    task ->
                    if(task.isSuccessful){
                            val intent = Intent(this, MenuAdmin::class.java)
                                startActivity(intent)
                    }else{
                        Toast.makeText(this, "O login falhou", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Os campos não podem estar vazios", Toast.LENGTH_SHORT).show()
            }

        }

        buttonUtilizador.setOnClickListener {
            finish()
        }


    }
}