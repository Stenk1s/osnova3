package com.example.sportlandapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportlandapp.ui.models.Ad
import java.util.*

class AdVIewModel : ViewModel() {
    private val _adList = MutableLiveData<List<Ad>>(emptyList())
    private val _Title = MutableLiveData<String>("")
    private val _Organization= MutableLiveData<String>("")
    private val _Sity= MutableLiveData<String>("")
    private val _Zarplata= MutableLiveData<String>("")
    private val _Opisanie= MutableLiveData<String>("")
    private val _Grafik= MutableLiveData<String>("")
    private val _opet= MutableLiveData<String>("")
    private val _Adres= MutableLiveData<String>("")
    private val _Trebovanie= MutableLiveData<String>("")
    private val _Namber= MutableLiveData<String>("")
    val adlist: LiveData<List<Ad>> = _adList
    fun adad(ad: Ad){
        val oldList =  adlist.value?.toMutableList()
        oldList?.add(ad)
        _adList.value = oldList?.toList()
    }
    fun adad1(Title:String, Organization:String, Sity:String, Zarplata:String, Namber:String ){
        _Title.value = Title
        _Sity.value = Sity
        _Organization.value = Organization
        _Zarplata.value = Zarplata
        _Namber.value = Namber
    }
}