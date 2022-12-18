package com.example.workjugend.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.workjugend.R
import com.example.workjugend.databinding.ActivityExitnotBinding


class InputScreen : Fragment(R.layout.activity_exitnot) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding =ActivityExitnotBinding.bind(view)
        binding.regiscexitnot.setOnClickListener {
            findNavController().navigate(R.id.action_inputScreen_to_registerScreen2)
        }
        binding.buttonPanelqwe.setOnClickListener {
            findNavController().navigate(R.id.action_inputScreen_to_osnova)
        }
        binding.loginLayout.typeface = Typeface.DEFAULT_BOLD
        binding.passwordLayout.typeface = Typeface.DEFAULT_BOLD

    }
}
