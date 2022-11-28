package com.example.sportlandapp.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.ActivityOsnovaBinding
import com.example.sportlandapp.ui.adapter.AdAdapter
import com.example.sportlandapp.viewmodel.AdVIewModel
import com.example.sportlandapp.viewmodel.UserViewModel

@Suppress("DEPRECATION")
class Osnova : Fragment(R.layout.activity_osnova) {
    private val Ad: AdVIewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ActivityOsnovaBinding.bind(view)
        if (userViewModel.email.value.toString().isEmpty())
            findNavController().navigate(R.id.action_osnova_to_registerScreen)
        binding.osnad.adapter = AdAdapter(Ad.adlist.value!!)
    }


}
