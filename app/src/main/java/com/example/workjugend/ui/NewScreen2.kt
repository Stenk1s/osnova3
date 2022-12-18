package com.example.workjugend.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.workjugend.R
import com.example.workjugend.databinding.NewsledMenuBinding
import com.example.workjugend.ui.models.Ad
import com.example.workjugend.viewmodel.AdVIewModel
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
            AdVIewModel.adad2(
                Opisanie = binding.opisanie.editText!!.text.toString(),
                Grafik = binding.grafikrabot.editText!!.text.toString(),
                opet = binding.opet.editText!!.text.toString(),
                Adres = binding.adres.editText!!.text.toString(),
                Trebovanie = binding.trebovania.editText!!.text.toString(),
            )
            AdVIewModel.adad(
                ad = Ad(
                    Title = AdVIewModel.title.value.toString(),
                    Sity = AdVIewModel.sity.value.toString(),
                    Organization =  AdVIewModel.organization.value.toString(),
                    Zarplata = AdVIewModel.zarplata.value.toString(),
                    Opisanie = AdVIewModel.opisanie.value.toString(),
                    Grafik = AdVIewModel.grafik.value.toString(),
                    Opet = AdVIewModel.opet.value.toString(),
                    Adres = AdVIewModel.adres.value.toString(),
                    Trebovanie = AdVIewModel.trebovanie.value.toString(),
                    Namber = AdVIewModel.namber.value.toString(),
                    Old = AdVIewModel.old.value.toString(),
                    Id = UUID.randomUUID()

                    )
            )
            Toast.makeText(requireContext(), "Объявление добавлено в профиль!", Toast.LENGTH_SHORT)
                .show()
            findNavController().navigate(R.id.action_newScreen2_to_osnova)
        }
    }
}




