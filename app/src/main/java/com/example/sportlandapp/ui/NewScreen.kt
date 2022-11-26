package com.example.sportlandapp.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.FormaActivityBinding
import com.example.sportlandapp.databinding.NewMenuBinding
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class NewScreen : Fragment(R.layout.new_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = NewMenuBinding.bind(view)
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
        binding.newnaosn.setOnClickListener {
            findNavController().navigate(R.id.action_newScreen_to_osnova)

        }

    }
}
