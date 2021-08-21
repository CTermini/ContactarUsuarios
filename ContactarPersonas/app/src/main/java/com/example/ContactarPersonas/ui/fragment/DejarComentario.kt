package com.example.ContactarPersonas.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ContactarPersonas.R
import com.example.ContactarPersonas.core.Binding
import com.example.ContactarPersonas.core.ViewModel
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
        viewModel = ViewModel.getViewModel(this)
        binding = Binding.getComentarioBinding(inflater,container)

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {

                persona = it.getParcelable("persona")!!

        }?: run {
            Toast.makeText(requireContext(), "argumentos nulos", Toast.LENGTH_SHORT).show()
        }

        Log.i("Seleccion", "onActivityCreated: $persona")
        with(binding) {
            button2.setOnClickListener {

                val nombre = tvNombreComentario.text.toString()
                val mensaje = tvMenajeComentario.text.toString()

                if (nombre.isNotEmpty() && mensaje.isNotEmpty()) {
                    viewModel.onAgregarClicked(
                        Mensaje(
                            0, nombre, mensaje,
                            persona?.id.toString()
                        )
                    )
                    val bundle = Bundle()
                    bundle.putParcelable("persona", persona)
                    ocultarTeclado()
                    findNavController().navigate(R.id.action_dejarComentario_to_persona, bundle)

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

    fun ocultarTeclado() {
        val vieww = requireActivity().currentFocus
        if (vieww != null) {
            val input =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            input.hideSoftInputFromWindow(vieww.windowToken, 0)
        }
    }
}
