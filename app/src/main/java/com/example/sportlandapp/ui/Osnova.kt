package com.example.sportlandapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.viewmodel.UserViewModel

class Osnova : Fragment(R.layout.activity_osnova) {

    private val userViewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (userViewModel.email.value.toString().isEmpty())
            findNavController().navigate(R.id.action_osnova_to_registerScreen)

    }
}
