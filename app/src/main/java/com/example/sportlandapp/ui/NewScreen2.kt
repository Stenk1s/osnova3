package com.example.sportlandapp.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.FormaActivityBinding
import com.example.sportlandapp.databinding.NewMenuBinding
import com.example.sportlandapp.databinding.NewsledMenuBinding
import com.example.sportlandapp.ui.models.Ad
import com.example.sportlandapp.viewmodel.AdVIewModel
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class NewScreen2 : Fragment(R.layout.newsled_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = NewsledMenuBinding.bind(view)
        binding.newnaosn.setOnClickListener {
            Toast.makeText(requireContext(), "Объявление добавлено в профиль!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_newScreen2_to_osnova)

        }
        binding.imageButton.setOnClickListener {
            findNavController().navigate(R.id.action_newScreen2_to_newScreen)

        }

    }
}

