package com.example.sportlandapp.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.FragmentRegisterSreenBinding
import com.example.sportlandapp.viewmodel.UserViewModel

class RegisterScreen : Fragment(R.layout.fragment__register_sreen) {

    private val userViewModel: UserViewModel by activityViewModels()
    private lateinit var binding: FragmentRegisterSreenBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterSreenBinding.bind(view)
        val passwordEditText = binding.passwordLayout
        val nameEditText = binding.nameLayout
        val loginEditText = binding.loginLayout

        passwordEditText.editText?.doOnTextChanged { text, _, _, _ ->
            if (text?.length!! < 8) passwordEditText.error =
                "Пароль должен иметь не менее 8 символов"
            else passwordEditText.error = null
        }
        loginEditText.editText?.doOnTextChanged { text, _, _, _ ->
            if (text?.length!! < 8 || !text.contains("@") || !text.contains("."))
                loginEditText.error = "Почта не существует"
            else {
                if (text.split("@")[0].length > 4 ||
                    text.split("@")[1].contains(".")
                ) loginEditText.error = null
                else
                    loginEditText.error = "Почта не существует"
            }
        }
        nameEditText.editText?.doOnTextChanged { text, _, _, _ ->
            if (text?.length!! < 2) nameEditText.error = "Ник должен иметь не менее 2 символов"
            else nameEditText.error = null
        }
        binding.apply {
            nameLayout.typeface = Typeface.DEFAULT_BOLD
            loginLayout.typeface = Typeface.DEFAULT_BOLD
            passwordLayout.typeface = Typeface.DEFAULT_BOLD
            buttonPanel.setOnClickListener { toNextScreen() }
            button2.setOnClickListener {
                findNavController().navigate(R.id.action_registerScreen_to_inputScreen)
            }
        }
    }

    private fun toNextScreen() {
        if (binding.nameLayout.editText!!.text.toString().isEmpty() ||
            (binding.loginLayout.editText!!.text.toString().isEmpty() ||
                    !binding.loginLayout.editText!!.text.toString().contains("@") ||
                    !binding.loginLayout.editText!!.text.toString().contains(".")) ||
            binding.passwordLayout.editText!!.text.toString().isEmpty()
        )
            Toast.makeText(
                requireContext(), "Неправельно заполнены поля", Toast.LENGTH_SHORT
            ).show()
        else {
            userViewModel.changeUserData1(
                name = binding.nameLayout.editText!!.text.toString(),
                email = binding.loginLayout.editText!!.text.toString(),
                password = binding.passwordLayout.editText!!.text.toString()
            )
            findNavController().navigate(R.id.action_registerScreen_to_forma)
        }
    }
}