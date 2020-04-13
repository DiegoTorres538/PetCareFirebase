package com.diegotorres.petcarefirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_pet_care.*

class LoginPetCare : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_pet_care)

        register_boton.setOnClickListener {
            goToRegistro()
        }

        login.setOnClickListener{
            goToMain()
        }
    }


    private fun goToRegistro(){
        val intent = Intent(this, RegistroPetCare::class.java)
        startActivityForResult(intent,1234)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun goToMain(){
        val userAux = user_login.text.toString()
        val passAux = pass_login.text.toString()
        val auth = FirebaseAuth.getInstance()

        if(!TextUtils.isEmpty(userAux) && !TextUtils.isEmpty(passAux)){
            auth.signInWithEmailAndPassword(userAux,passAux).addOnCompleteListener(this) {
                task ->
                if(task.isSuccessful){
                    val datoMain = Intent(this,MainActivity::class.java)
                    startActivity(datoMain)
                    finish()
                }
                else{
                    Toast.makeText(this,"Usuario no registrado",Toast.LENGTH_SHORT).show()
                }
            }
        }
        else{
            Toast.makeText(this,"Por favor llena los campos",Toast.LENGTH_SHORT).show()
        }
    }
}

