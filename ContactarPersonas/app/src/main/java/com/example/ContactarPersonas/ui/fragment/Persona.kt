package com.example.ContactarPersonas.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ContactarPersonas.R
import com.example.ContactarPersonas.adapter.AdapterPersonas
import com.example.ContactarPersonas.data.model.Data
import com.example.ContactarPersonas.data.model.Mensaje
import com.example.ContactarPersonas.databinding.FragmentDejarComentarioBinding
import com.example.ContactarPersonas.databinding.FragmentPersonaBinding
import com.example.ContactarPersonas.ui.main.MainViewModel

class Persona : Fragment() {
    lateinit var binding: FragmentPersonaBinding
    lateinit var bindingMensaje: FragmentDejarComentarioBinding
    private lateinit var persona: Data
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = FragmentPersonaBinding.inflate(inflater, container, false)
        bindingMensaje = FragmentDejarComentarioBinding.inflate(inflater, container, false)
        arguments.let {
            if (it != null) {
                persona = it.getParcelable<Data>("loco")!!
            }
        }
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        Log.i("persona", "onActivityCreated:$persona ")
        with(binding) {

            Glide.with(requireActivity()).load(persona.avatar).apply(
                RequestOptions().override(500, 500)
            ).into(imageView)

            tvMensaje.text = persona.first_name.plus(" ").plus(persona.last_name)
            tvCorreo.text = persona.email

            val adapter = AdapterPersonas(lista = mutableListOf<Mensaje>())
            rvPersona.layoutManager = LinearLayoutManager(requireContext())
            rvPersona.adapter = adapter

            viewModel.onListarId(persona.id.toString()).observe(viewLifecycleOwner, Observer {

                adapter.setMensaje(it)

            })
            val bundle = Bundle()
            bundle.putInt("id", persona.id)
            bundle.putParcelable("loco", persona)

            button.setOnClickListener {

                findNavController().navigate(R.id.action_persona_to_dejarComentario, bundle)

            }

        }

    }

}

