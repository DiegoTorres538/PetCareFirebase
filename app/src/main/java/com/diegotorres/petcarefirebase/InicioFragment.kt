package com.diegotorres.petcarefirebase

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_inicio.view.*

/**
 * A simple [Fragment] subclass.
 */
class InicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_inicio, container, false)
        root.botonpublicar.setOnClickListener {
            Toast.makeText(context,"envia contenido",Toast.LENGTH_SHORT).show()
        }
        return root
    }

}