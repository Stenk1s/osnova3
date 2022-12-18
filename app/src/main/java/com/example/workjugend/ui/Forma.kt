package com.example.workjugend.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.workjugend.R
import com.example.workjugend.databinding.FormaActivityBinding
import com.example.workjugend.viewmodel.UserViewModel
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher


class Forma : Fragment(R.layout.forma_activity) {
    private lateinit var binding: FormaActivityBinding
    private val UserViewModel: UserViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FormaActivityBinding.bind(view)

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
        binding.siti.typeface = Typeface.DEFAULT_BOLD
        binding.data.typeface = Typeface.DEFAULT_BOLD
        binding.butonnaosn.setOnClickListener {
            toNextFor()
        }
        val mask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER)
        mask.isHideHardcodedHead = true
        val formatWatcher: FormatWatcher = MaskFormatWatcher(mask)
        formatWatcher.installOn(binding.namber2)
    }

    private fun toNextFor() {
        if (binding.famili.editText!!.text.toString().isEmpty() ||
            binding.namber.editText!!.text.toString().isEmpty() ||
            binding.data.editText!!.text.toString().isEmpty() ||
            binding.siti.editText!!.text.toString().isEmpty()
        ) Toast.makeText(
            requireContext(), "Заполните поля ввода", Toast.LENGTH_SHORT
        ).show()
        else {

            UserViewModel.changeUserData2(
                family = binding.famili.editText!!.text.toString(),
                namber = binding.namber.editText!!.text.toString(),
                sity = binding.siti.editText!!.text.toString(),
                neim = binding.neim.editText!!.text.toString(),
                data = binding.data.editText!!.text.toString(),
            )
            findNavController().navigate(R.id.action_forma_to_osnova)
        }
    }
}





