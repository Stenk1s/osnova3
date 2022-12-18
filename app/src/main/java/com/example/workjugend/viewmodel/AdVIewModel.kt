package com.example.workjugend.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workjugend.ui.models.Ad

class AdVIewModel : ViewModel() {
    private val _adList = MutableLiveData<List<Ad>>(emptyList())
    private val _Title = MutableLiveData<String>("")
    private val _Organization= MutableLiveData<String>("")
    private val _Sity= MutableLiveData<String>("")
    private val _Zarplata= MutableLiveData<String>("")
    private val _Opisanie= MutableLiveData<String>("")
    private val _Grafik= MutableLiveData<String>("")
    private val _opet= MutableLiveData<String>("")
    private val _Old= MutableLiveData<String>("")
    private val _Adres= MutableLiveData<String>("")
    private val _Trebovanie= MutableLiveData<String>("")
    private val _Namber= MutableLiveData<String>("")
    val adlist: LiveData<List<Ad>> = _adList
    val sity: LiveData<String> = _Sity
    val organization: LiveData<String> = _Organization
    val zarplata: LiveData<String> = _Zarplata
    val old: LiveData<String> = _Old
    val opisanie: LiveData<String> = _Opisanie
    val grafik: LiveData<String> = _Grafik
    val opet: LiveData<String> = _opet
    val adres: LiveData<String> = _Adres
    val trebovanie: LiveData<String> = _Trebovanie
    val namber: LiveData<String> = _Namber
    val title: LiveData<String> = _Title

    fun adad(ad: Ad){
        val oldList =  adlist.value?.toMutableList()
        oldList?.add(ad)
        _adList.value = oldList?.toList()
    }
    fun adad1(Title:String,Old:String, Organization:String, Sity:String, Zarplata:String, Namber:String ){
        _Title.value = Title
        _Sity.value = Sity
        _Organization.value = Organization
        _Zarplata.value = Zarplata
        _Namber.value = Namber
        _Old.value = Old
    }
    fun adad2(Opisanie:String, Grafik:String, opet:String, Adres:String, Trebovanie:String ){
        _Opisanie.value = Opisanie
        _Grafik.value = Grafik
        _opet.value = opet
        _Adres.value = Adres
        _Trebovanie.value = Trebovanie
    }
}