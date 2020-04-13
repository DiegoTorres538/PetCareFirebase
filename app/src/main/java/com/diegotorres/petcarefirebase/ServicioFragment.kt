package com.diegotorres.petcarefirebase

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_servicio.view.*

/**
 * A simple [Fragment] subclass.
 */
class ServicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_servicio, container, false)

        root.imbpetsitt.setOnClickListener {
            infoContact()
        }

        root.imbdogsitt.setOnClickListener {
            dogInfoContact()
        }
        return root
    }
    private fun infoContact(){
        val intent = Intent(context,PetSittActivity::class.java)
        startActivity(intent)
    }

    private fun dogInfoContact(){
        val intent = Intent(context,DogSittActivity::class.java)
        startActivity(intent)
    }

}
