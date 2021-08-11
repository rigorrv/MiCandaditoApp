package com.example.micandaditoapp.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.micandaditoapp.R
import com.example.micandaditoapp.adapter.propiedadesadapter.LocalItemDetailsLookup
import com.example.micandaditoapp.adapter.propiedadesadapter.PropidadesAdapter
import com.example.micandaditoapp.databinding.*
import com.example.micandaditoapp.model.mockData
import com.example.micandaditoapp.screen.fragmentos.FragmentoBusquedaConfig
import com.example.testingrecyclerviewselection.adapters.propiedadesinfoadapter.PicturesAdapter

class FragmentoPropiedadesCompRenta : Fragment() {
    private lateinit var adapter: PropidadesAdapter
    lateinit var rootView: FragmentPropiedadesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = FragmentPropiedadesBinding.inflate(inflater, container, false)
        return rootView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(context)
        var picturesAdapter = PicturesAdapter(context, mockData()[0].imagenes)
        rootView.run {
            rootView.list.layoutManager = layoutManager
            propiedadesToolBar.title = mockData()[0].direccion
            propiedadesToolBar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.userBtn -> {
                        activity?.supportFragmentManager?.commit {
                            replace(R.id.fragment2, FragmentoUsuario(), "VentaRenta")
                            addToBackStack(null)
                        }
                    }
                    R.id.searchBtn -> {
                        activity?.supportFragmentManager?.commit {
                            replace(R.id.fragment2, FragmentoBusquedaConfig(), "VentaRenta")
                            addToBackStack(null)
                        }
                    }
                }
                true
            }
            propiedadesToolBar.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
            fotosPropiedadesBtn.text = "Foto"
            mapaPropiedadesBtn.text = "Mapa"

            adapter = PropidadesAdapter()
            adapter.setHasStableIds(true)
            list.adapter = adapter
            adapter.getInfo(mockData())

            val tracker = SelectionTracker.Builder<Long>(
                "number-selection",
                list,
                StableIdKeyProvider(list),
                LocalItemDetailsLookup(list),
                StorageStrategy.createLongStorage()
            ).withSelectionPredicate(object : SelectionTracker.SelectionPredicate<Long>() {
                override fun canSetStateForKey(key: Long, nextState: Boolean): Boolean {
                    picturesAdapter =
                        PicturesAdapter(context, mockData()[key.toInt()].imagenes)
                    imagenesAdapter.adapter = picturesAdapter
                    propiedadesToolBar.title = mockData()[key.toInt()].direccion
                    if (nextState == false) {
                        activity?.supportFragmentManager?.commit {
                            replace(
                                R.id.fragment2,
                                FragmentoPropiedadesInformacion(mockData()[key.toInt()]),
                                "VentaRenta"
                            )
                            addToBackStack(null)
                        }
                    }
                    return true
                }

                override fun canSetStateAtPosition(
                    position: Int,
                    nextState: Boolean
                ): Boolean {
                    return true
                }

                override fun canSelectMultiple(): Boolean {
                    return false // Set to false to allow single selecting
                }
            }).build()
            imagenesAdapter.adapter = picturesAdapter
            adapter.tracker = tracker
            adapter.getInfo(mockData())
        }
    }
}
