package com.example.ContactarPersonas.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ContactarPersonas.R
import com.example.ContactarPersonas.data.model.Data
import com.example.ContactarPersonas.data.model.Mensaje
import com.example.ContactarPersonas.databinding.FragmentDejarComentarioBinding
import com.example.ContactarPersonas.ui.main.MainViewModel

class DejarComentario : Fragment() {
    private lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentDejarComentarioBinding
    private var persona: Data? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = FragmentDejarComentarioBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments.let {
            if (it != null) {
                persona = it.getParcelable<Data>("loco")!!

            }
        }
        Log.i("TAG", "onActivityCreated: $persona")
        with(binding) {
            button2.setOnClickListener {

                val nombre = tvNombreComentario.text.toString()
                val mensaje = tvMenajeComentario.text.toString()

                if (nombre.isNotEmpty() && mensaje.isNotEmpty()) {
                    viewModel.onAgregarClicked(
                        Mensaje(
                            0, nombre, mensaje,
                            arguments?.getInt("id").toString()
                        )
                    )
                    val bundle = Bundle()
                    bundle.putParcelable("loco", persona)
                    findNavController().navigate(R.id.action_persona_self, bundle)
                } else {
                    if (nombre.isEmpty()) {
                        tvNombreComentario.error = getText(R.string.campoVacio)
                    }
                    if (mensaje.isEmpty()) {
                        tvMenajeComentario.error = getText(R.string.campoVacio)
                    }
                }
            }
        }
    }

}
