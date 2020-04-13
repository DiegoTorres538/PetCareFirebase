package com.diegotorres.petcarefirebase

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_pet.view.*

/**
 * A simple [Fragment] subclass.
 */
class PetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_pet, container, false)
        root.boton_agregar.setOnClickListener {
            addPet()
        }
        return root
    }

    private fun addPet(){
        val intent = Intent(context,AddPetActivity::class.java)
        startActivity(intent)
    }

}

