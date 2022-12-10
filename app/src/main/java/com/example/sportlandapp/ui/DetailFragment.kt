package com.example.sportlandapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sportlandapp.R
import com.example.sportlandapp.databinding.DetailFragmentBinding
import com.example.sportlandapp.ui.models.Ad
import com.example.sportlandapp.viewmodel.AdVIewModel

class DetailFragment: Fragment(R.layout.detail_fragment) {
    private val AdViewModel: AdVIewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding: DetailFragmentBinding = DetailFragmentBinding.bind(view)
        val allAds = AdViewModel.adlist.value!!
        val currentAd = allAds.find {
            it.Id.toString() == requireArguments().getString("ID")
        }
        if (currentAd != null) {
            binding.title.text = currentAd.Title
        }
    }
}