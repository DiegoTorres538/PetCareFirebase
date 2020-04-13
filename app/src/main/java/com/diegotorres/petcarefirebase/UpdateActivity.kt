package com.diegotorres.petcarefirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diegotorres.petcarefirebase.model.Usuario
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity() {

    lateinit var nombre:String
    lateinit var user:String
    lateinit var correo:String
    lateinit var pass:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        bt_save.setOnClickListener {
            updateFireBase()
        }
    }

    private fun updateFireBase(){
        nombre = ed_name.text.toString()
        user = ed_user.text.toString()
        correo = ed_email.text.toString()
        pass = ed_pass.text.toString()

        var perfil = Usuario()
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Usuarios")
        val postListener = object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    perfil = dataSnapshot.getValue(Usuario::class.java)!!
                }

        }
        myRef.addValueEventListener(postListener)

        val childUpdates = HashMap<String,Any>()
        childUpdates["nombre"] = nombre
        childUpdates["user"] = user
        childUpdates["correo"] = correo
        childUpdates["password"] = pass
        myRef.child(perfil.id).updateChildren(childUpdates)


    }
}
