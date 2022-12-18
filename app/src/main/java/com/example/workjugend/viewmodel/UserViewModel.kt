package com.example.workjugend.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val _email = MutableLiveData<String>("")
    private val _password = MutableLiveData<String>("")
    private val _name = MutableLiveData<String>("")
    private val _family = MutableLiveData<String>("")
    private val _neim = MutableLiveData<String>("")
    private val _sity = MutableLiveData<String>("")
    private val _data = MutableLiveData<String>("")
    private val _namber = MutableLiveData<String>("")
    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val name: LiveData<String> = _name
    val family: LiveData<String> = _family
    val neim: LiveData<String> = _neim
    val sity: LiveData<String> = _sity
    val data: LiveData<String> = _data
    val namber: LiveData<String> = _namber


    fun changeUserData2(neim: String, family: String, sity: String, data: String, namber: String) {
        _neim.value = neim
        _family.value = family
        _data.value = data
        _sity.value = sity
        _namber.value = namber

    }

    fun changeUserData1(password: String, email: String, name: String) {
        _password.value = password
        _email.value = email
        _name.value = name

    }

}