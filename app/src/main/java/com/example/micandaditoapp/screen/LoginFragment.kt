package com.example.micandaditoapp.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.micandaditoapp.R
import com.example.micandaditoapp.databinding.*
import com.example.micandaditoapp.screen.fragmentos.FragmentoRegistrar

class LoginFragment : Fragment() {

    lateinit var rootView: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = FragmentLoginBinding.inflate(inflater, container, false)
        return rootView.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rootView.run {
            logo.setOnClickListener {
                activity?.supportFragmentManager?.commit {
                    replace(R.id.fragment2, FragmentoVentaRenta(), "VentaRenta")
                    addToBackStack(null)
                }
            }
            registerBtn.setOnClickListener {
                activity?.supportFragmentManager?.commit {
                    replace(R.id.fragment2, FragmentoRegistrar(), "VentaRenta")
                    addToBackStack(null)
                }
            }
        }
    }
}