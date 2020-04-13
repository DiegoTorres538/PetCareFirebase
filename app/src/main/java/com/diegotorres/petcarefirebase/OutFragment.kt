package com.diegotorres.petcarefirebase

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_out.view.*
import java.util.jar.Manifest

/**
 * A simple [Fragment] subclass.
 */
class OutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_out, container, false)
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.user_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.update ->{
                goToUpdate()
            }

            R.id.out -> {
                goToInicio()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun goToInicio(){
        val intent = Intent(context,LoginPetCare::class.java)
        startActivity(intent)
    }

    private fun goToUpdate(){
        val intent = Intent(context,UpdateActivity::class.java)
        startActivity(intent)
    }
}
