package com.example.sportlandapp.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.NewsledMenuBinding

class NewScreen2 : Fragment(R.layout.newsled_menu) {
    private lateinit var binding: NewsledMenuBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NewsledMenuBinding.bind(view)
        binding.imageButton.setOnClickListener {
            findNavController().navigate(R.id.action_newScreen2_to_newScreen)

            binding.apply {
                opisanie.typeface = Typeface.DEFAULT_BOLD
                trebovania.typeface = Typeface.DEFAULT_BOLD
                adres.typeface = Typeface.DEFAULT_BOLD
                grafikrabot.typeface = Typeface.DEFAULT_BOLD
                opet.typeface = Typeface.DEFAULT_BOLD
                newnaosn.setOnClickListener { toNextOsnova() }
            }

        }
    }

    private fun toNextOsnova() {
        if (binding.opisanie.editText!!.text.toString().isEmpty() ||
            (!binding.trebovania.editText!!.text.toString().isEmpty() ||
                    binding.grafikrabot.editText!!.text.toString().isEmpty()
                    )
        )
            Toast.makeText(
                requireContext(), "Неправельно заполнены поля", Toast.LENGTH_SHORT
            ).show()
        else {
            Toast.makeText(requireContext(), "Объявление добавлено в профиль!", Toast.LENGTH_SHORT)
                .show()
            findNavController().navigate(R.id.action_newScreen2_to_osnova)
        }
    }
}




