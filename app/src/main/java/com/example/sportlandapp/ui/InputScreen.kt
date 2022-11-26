package com.example.sportlandapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.ActivityExitnotBinding
import com.example.sportlandapp.databinding.FragmentRegisterSreenBinding

class InputScreen : Fragment(R.layout.activity_exitnot) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ActivityExitnotBinding.bind(view)
        binding.regiscexitnot.setOnClickListener {
            findNavController().navigate(R.id.action_inputScreen_to_registerScreen2)
        }
        binding.buttonPanelqwe.setOnClickListener {
            findNavController().navigate(R.id.action_inputScreen_to_osnova)
        }

    }
}
