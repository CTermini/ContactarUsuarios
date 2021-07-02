package com.example.ContactarPersonas.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ContactarPersonas.R
import com.example.ContactarPersonas.adapter.AdapterRv
import com.example.ContactarPersonas.data.model.Data
import com.example.ContactarPersonas.databinding.MainFragmentBinding
import com.example.ContactarPersonas.ui.main.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() =
            MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding
    private val adapter=AdapterRv()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MainFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        with(binding) {
            cargarRv()
            viewModel.obtenerUsuarios()

            viewModel.isLoadingProgressBar.observe(viewLifecycleOwner, Observer {
                binding.progress.isVisible = it
            })

            viewModel.listaUsr.observe(viewLifecycleOwner, Observer {
                adapter.setPersona(it)
            })

            adapter.setOnPersonaClick(object : AdapterRv.onPersonaClickListener {
                override fun onPersonaClick(data: Data) {
                    val puente = Bundle()
                    puente.putParcelable("loco", data)

                    findNavController().navigate(R.id.action_mainFragment_to_persona, puente)
                }
            })
        }

    }

    fun cargarRv() {
        with(binding) {

            rvLista.layoutManager = LinearLayoutManager(requireContext())
            rvLista.adapter = adapter

        }
    }

}