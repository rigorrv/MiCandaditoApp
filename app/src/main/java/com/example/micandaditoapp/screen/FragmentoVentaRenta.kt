package com.example.micandaditoapp.screen

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.Fragment
import com.example.micandaditoapp.R
import com.example.micandaditoapp.databinding.*
import com.example.micandaditoapp.screen.asociados.FragmentoAsociados

class FragmentoVentaRenta : Fragment() {

    lateinit var rootView: FragmentVentaRentaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView =
            FragmentVentaRentaBinding.inflate(inflater, container, false)
        return rootView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootView.run {
            rentaCasaBtn.setOnClickListener {
                getFragmentoCompraRenta()
            }
        }
    }

    private fun getFragmentoCompraRenta() {
        activity?.supportFragmentManager?.commit {
            replace(R.id.fragment2, FragmentoAsociados(), "VentaRenta")
            addToBackStack(null)
        }
    }

    private fun getFragmentoVenta() {
        Toast.makeText(context, "Venta", Toast.LENGTH_SHORT).show()
    }
}