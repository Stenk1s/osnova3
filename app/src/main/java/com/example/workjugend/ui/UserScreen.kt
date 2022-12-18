package com.example.workjugend.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.workjugend.R
import com.example.workjugend.databinding.UserMenuBinding
import com.example.workjugend.viewmodel.UserViewModel


class UserScreen : Fragment(R.layout.user_menu) {
    private val userViewModel: UserViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding: UserMenuBinding = UserMenuBinding.bind(view)
        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_userScreen_to_registerScreen)
        }

        binding.user = userViewModel
        binding.lifecycleOwner = viewLifecycleOwner

    }

}
