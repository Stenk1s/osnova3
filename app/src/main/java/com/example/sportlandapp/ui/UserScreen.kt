package com.example.sportlandapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.UserMenuBinding
import com.example.sportlandapp.viewmodel.UserViewModel

class UserScreen : Fragment(R.layout.user_menu){
    private val userViewModel: UserViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding: UserMenuBinding = UserMenuBinding.bind(view)

        binding.user = userViewModel
        binding.lifecycleOwner = viewLifecycleOwner

    }
}