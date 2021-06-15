package com.example.projetocm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetocm.adapter.ReservaAdapter
import com.example.projetocm.api.Encomendas
import com.example.projetocm.api.EndPoints
import com.example.projetocm.api.ServiceBuilder
import com.example.projetocm.databinding.FragmentListarReservasBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListarReservas: Fragment() {

    private lateinit var encomendas: List<Encomendas>
    private var _binding: FragmentListarReservasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListarReservasBinding.inflate(inflater, container, false)

        //Toolbar
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        val request = ServiceBuilder.buildService(EndPoints::class.java)
        val call = request.getEncomendas()
        call.enqueue(object : Callback<List<Encomendas>> {
            override fun onResponse(call: Call<List<Encomendas>>, response: Response<List<Encomendas>>) {
                if(response.isSuccessful) {
                    encomendas = response.body()!!
                    encomendas?.let {
                        //RecyclerView
                        binding.recyclerViewReservaList.layoutManager = LinearLayoutManager(requireContext())
                        binding.recyclerViewReservaList.adapter = ReservaAdapter(encomendas)
                    }
                }
            }
            override fun onFailure(call: Call<List<Encomendas>>, t: Throwable) {
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