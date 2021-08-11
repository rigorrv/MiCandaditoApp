package com.example.testingrecyclerviewselection.screen.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.micandaditoapp.R
import com.example.micandaditoapp.databinding.*
import com.example.micandaditoapp.screen.FragmentoPropiedades


class FragmentSetUpSearch : Fragment() {

    lateinit var rootView: FragmentoConfigurandoBusquedaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = FragmentoConfigurandoBusquedaBinding.inflate(inflater, container, false)
        return rootView.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rootView.aceptarInfoBtn.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                replace(R.id.fragment2, FragmentoPropiedades(), "VentaRenta")
                addToBackStack(null)
            }
        }
    }

    private fun getInfo(boolean: Boolean) {
        if (boolean)
            rootView.progressBarInfo.visibility = View.VISIBLE
        else
            rootView.aceptarInfoBtn.visibility = View.GONE
    }
}