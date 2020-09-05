package com.pawelwlazlo.navigationcomponentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation


class MainFragment : Fragment(), View.OnClickListener {
     lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        view.findViewById<Button>(R.id.settings_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.info_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.geenrate_number_button).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.settings_button ->{
                navController!!.navigate(R.id.action_mainFragment_to_settingsFragment)
            }
            R.id.info_button ->{
                navController!!.navigate(R.id.action_mainFragment_to_aboutFragment)
            }
            R.id.geenrate_number_button ->{
                navController!!.navigate(R.id.action_mainFragment_to_randomNumberFragment)
            }
        }
    }


}