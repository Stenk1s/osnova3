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
import com.example.sportlandapp.databinding.FragmentRegisterSreenBinding
import com.example.sportlandapp.databinding.NewMenuBinding
import com.example.sportlandapp.ui.models.Ad
import com.example.sportlandapp.viewmodel.AdVIewModel
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class NewScreen : Fragment(R.layout.new_menu) {
    private val AdVIewModel: AdVIewModel by activityViewModels()
    private lateinit var binding: NewMenuBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NewMenuBinding.bind(view)
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
        binding.apply {
            zp.typeface = Typeface.DEFAULT_BOLD
            name.typeface = Typeface.DEFAULT_BOLD
            siti.typeface = Typeface.DEFAULT_BOLD
            organization.typeface = Typeface.DEFAULT_BOLD
            opisanie.typeface = Typeface.DEFAULT_BOLD
            old.typeface = Typeface.DEFAULT_BOLD
            newnaosn.setOnClickListener { toNextmenu() }
            imageButton.setOnClickListener {
                findNavController().navigate(R.id.action_newScreen_to_osnova)
            }


        }
    }

    private fun toNextmenu() {
        if (binding.zp.editText!!.text.toString().isEmpty() ||
            (binding.name.editText!!.text.toString().isEmpty()
                    || binding.opisanie.editText!!.text.toString().isEmpty()) ||
            binding.siti.editText!!.text.toString().isEmpty()
        )
            Toast.makeText(
                requireContext(), "Неправельно заполнены поля", Toast.LENGTH_SHORT
            ).show()
        else {
            AdVIewModel.adad(
                Ad(
                    binding.organization.editText!!.text.toString(),
                    binding.name.editText!!.text.toString(),
                    binding.siti.editText!!.text.toString(),
                    binding.zp.editText!!.text.toString()
                )
            )
            findNavController().navigate(R.id.action_newScreen_to_newScreen2    )
        }
    }
}

