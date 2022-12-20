package com.example.workjugend.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.workjugend.R
import com.example.workjugend.databinding.NewMenuBinding
import com.example.workjugend.viewmodel.AdVIewModel
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher


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
            zp.typeface = Typeface.DEFAULT_BOLD
            old.typeface = Typeface.DEFAULT_BOLD
            newnaosn.setOnClickListener {
                binding.newnaosn.setOnClickListener {
                    toNextmenu()

                }
            }
            imageButton.setOnClickListener {
                findNavController().navigate(R.id.action_newScreen_to_osnova)
            }


        }
        val mask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER)
        mask.isHideHardcodedHead = true
        val formatWatcher: FormatWatcher = MaskFormatWatcher(mask)
        formatWatcher.installOn(binding.namber3)
    }

    private fun toNextmenu() {
        if (binding.zp.editText!!.text.toString().isEmpty() ||
            (binding.name.editText!!.text.toString().isEmpty()
                    || binding.namber5.editText!!.text.toString().isEmpty()) ||
            binding.siti.editText!!.text.toString().isEmpty()
        )
            Toast.makeText(
                requireContext(), "Неправельно заполнены поля", Toast.LENGTH_SHORT
            ).show()
        else {
            AdVIewModel.adad1(
                Organization = binding.organization.editText!!.text.toString(),
                Title = binding.name.editText!!.text.toString(),
                Sity = binding.siti.editText!!.text.toString(),
                Zarplata = binding.zp.editText!!.text.toString(),
                Namber = binding.namber5.editText!!.text.toString(),
                Old = binding.old.editText!!.text.toString(),
            )
            findNavController().navigate(R.id.action_newScreen_to_newScreen2)
        }
    }
}

