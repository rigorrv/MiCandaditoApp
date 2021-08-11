package com.example.micandaditoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.micandaditoapp.screen.FragmentoPropiedadesCompRenta
import com.example.micandaditoapp.screen.FragmentoTutorialCompra
import com.example.micandaditoapp.screen.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            add(R.id.fragment2, FragmentoPropiedadesCompRenta(), "NULL")
            addToBackStack(null)
        }
    }
}