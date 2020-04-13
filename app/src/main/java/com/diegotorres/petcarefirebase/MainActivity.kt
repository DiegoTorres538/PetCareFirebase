package com.diegotorres.petcarefirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var usuario:String
    lateinit var correo:String
    lateinit var password:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration= AppBarConfiguration(
            setOf(
                R.id.navigation_inicio, R.id.navigation_pet, R.id.navigation_servicio, R.id.navigation_out
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val aux = intent?.extras
        usuario = aux?.getString("Usuario").toString()
        correo = aux?.getString("Correo").toString()
        password = aux?.getString("Contraseña").toString()
    }

    private fun goToLoginActivity(){
        val intent = Intent(this, LoginPetCare::class.java)
        intent.putExtra("Usuario",usuario).toString()
        intent.putExtra("Correo",correo).toString()
        intent.putExtra("Contraseña",password).toString()
        startActivity(intent)
        finish()
    }
}