package com.diegotorres.petcarefirebase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.diegotorres.petcarefirebase.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registro_pet_care.*


class RegistroPetCare : AppCompatActivity() {
    lateinit var nombre:String
    lateinit var user:String
    lateinit var correo:String
    lateinit var pass:String
    lateinit var reppass:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_pet_care)

        botonregistrar.setOnClickListener{
            datosRegistro()
        }
    }

    private fun datosRegistro() {
        nombre = nombre_registro.text.toString()
        user = usuario_registro.text.toString()
        correo = correo_registro.text.toString()
        pass = pass_registro.text.toString()
        reppass = rep_pass.text.toString()
        when {
            pass != reppass -> {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
            pass.length < 6 -> {
                Toast.makeText(this, "La contraseña debe tener minimo 6 caracteres", Toast.LENGTH_SHORT)
                    .show()
            }
            else -> {
                val intentRegistro = Intent()
                intentRegistro.putExtra("Usuario", user)
                intentRegistro.putExtra("Correo", correo)
                intentRegistro.putExtra("Contraseña", pass)
                setResult(Activity.RESULT_OK, intentRegistro)
                finish()
                saveFireBase(nombre,user,correo,pass)
            }
        }
    }

    private fun saveFireBase(nombre:String, usuario:String, correo:String, password:String){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Usuarios")
        val idUsuario = myRef.push().key

        val nwuser = Usuario(idUsuario!!, nombre, usuario, correo, password)
        myRef.child(idUsuario).setValue(nwuser)

        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(correo,password).addOnCompleteListener(this){
            task ->
            if(task.isComplete){
                val user:FirebaseUser? = auth.currentUser
            }
        }
    }


    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
        super.onBackPressed()
    }
}