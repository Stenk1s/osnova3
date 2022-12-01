package com.example.sportlandapp.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.ActivityMainBinding.bind
import com.example.sportlandapp.databinding.FormaActivityBinding
import com.example.sportlandapp.ui.models.Ad
import com.example.sportlandapp.viewmodel.AdVIewModel
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class Forma : Fragment(R.layout.forma_activity) {
    private val AdVIewModel: AdVIewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FormaActivityBinding.bind(view)
        val items = arrayOf(
            "Тобольск",
            "Тобольский район",
            "Москва",
            "Заводоуковск",
            "Ишим",
            "Ялуторовск",
            "Тюмень",
            "Санкт Петербург"
        )
        (binding.siti.editText as? MaterialAutoCompleteTextView)?.setSimpleItems(items)
        binding.neim.typeface = Typeface.DEFAULT_BOLD
        binding.famili.typeface = Typeface.DEFAULT_BOLD
        binding.namber.typeface = Typeface.DEFAULT_BOLD
        binding.butonnaosn.setOnClickListener {
            findNavController().navigate(R.id.action_forma_to_osnova)
        }

    }
}


