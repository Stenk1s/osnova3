package com.example.sportlandapp.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.NewsledMenuBinding
import com.example.sportlandapp.ui.models.Ad
import com.example.sportlandapp.viewmodel.AdVIewModel
import java.util.*

class NewScreen2 : Fragment(R.layout.newsled_menu) {
    private val AdVIewModel: AdVIewModel by activityViewModels()
    private lateinit var binding: NewsledMenuBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NewsledMenuBinding.bind(view)
        binding.apply {
            opisanie.typeface = Typeface.DEFAULT_BOLD
            trebovania.typeface = Typeface.DEFAULT_BOLD
            adres.typeface = Typeface.DEFAULT_BOLD
            grafikrabot.typeface = Typeface.DEFAULT_BOLD
            opet.typeface = Typeface.DEFAULT_BOLD
            newnaosn.setOnClickListener {
                toNextOsnova()

            }
        }


    }

    private fun toNextOsnova() {
        if (binding.opisanie.editText!!.text.toString().isEmpty() ||
            ((binding.trebovania.editText!!.text.toString().isEmpty() ||
                    binding.grafikrabot.editText!!.text.toString().isEmpty())
                    )
        )
            Toast.makeText(
                requireContext(), "Неправельно заполнены поля", Toast.LENGTH_SHORT
            ).show()
        else {
            AdVIewModel.adad(
                Ad(
                    Organization = AdVIewModel.
                    Title = binding.name.editText!!.text.toString(),
                    Sity = binding.siti.editText!!.text.toString(),
                    Zarplata = binding.zp.editText!!.text.toString(),
                    Namber = binding.namber5.editText!!.text.toString(),
                    Id = UUID.randomUUID()
                )
            )
            Toast.makeText(requireContext(), "Объявление добавлено в профиль!", Toast.LENGTH_SHORT)
                .show()
            findNavController().navigate(R.id.action_newScreen2_to_osnova)
        }
    }
}




