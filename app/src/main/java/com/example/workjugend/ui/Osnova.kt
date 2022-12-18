package com.example.workjugend.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.workjugend.R
import com.example.workjugend.databinding.ActivityOsnovaBinding
import com.example.workjugend.ui.adapter.AdAdapter
import com.example.workjugend.viewmodel.AdVIewModel
import com.example.workjugend.viewmodel.UserViewModel

class Osnova : Fragment(R.layout.activity_osnova) {
    private val Ad: AdVIewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ActivityOsnovaBinding.bind(view)
        if (userViewModel.email.value.toString().isEmpty() || userViewModel.name.value.toString()
                .isEmpty() || userViewModel.password.value.toString().isEmpty()
        ) findNavController().navigate(R.id.action_osnova_to_registerScreen)
        binding.osnad.adapter = AdAdapter(Ad.adlist.value!!) {
            val args = Bundle()
            args.putString("ID", it)
            findNavController().navigate(R.id.action_osnova_to_detailFragment, args)
        }
    }


}
