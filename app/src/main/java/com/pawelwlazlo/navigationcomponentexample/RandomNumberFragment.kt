package com.pawelwlazlo.navigationcomponentexample

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlin.random.Random


class RandomNumberFragment : Fragment(), View.OnClickListener {
     lateinit var navController: NavController
    lateinit var randomNumberTextView: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_random_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        randomNumberTextView=view.findViewById(R.id.generate_number_et)
        view.findViewById<Button>(R.id.generate_new_number_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.confirm_generated_number_button).setOnClickListener(this)
    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.generate_new_number_button->{
                randomNumberTextView.setText(randomInt().toString())
            }
            R.id.confirm_generated_number_button->{
                if (!TextUtils.isEmpty(randomNumberTextView.text.toString())){
                    if (randomNumberTextView.text.toString()!="0"){
                        val bundle = bundleOf("randomNumber" to randomNumberTextView.text.toString())
                        navController.navigate(R.id.action_randomNumberFragment_to_confirmationFragment,bundle)

                    }
                    else{
                        Toast.makeText(activity,"Number can not be equals 0", Toast.LENGTH_LONG).show()
                    }

                }
                else{
                    Toast.makeText(activity,"Please enter or generate number", Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    fun randomInt(): Int {
        var randomInt = Random.nextInt(0,200);
        return randomInt

    }

}