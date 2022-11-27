package com.example.sportlandapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportlandapp.ui.models.Ad

class AdVIewModel : ViewModel() {
    private val _adList = MutableLiveData<List<Ad>>(emptyList())
    val adlist: LiveData<List<Ad>> = _adList
    fun adad(ad: Ad){
        val oldList =  adlist.value?.toMutableList()
        oldList?.add(ad)
        _adList.value = oldList?.toList()
    }
}