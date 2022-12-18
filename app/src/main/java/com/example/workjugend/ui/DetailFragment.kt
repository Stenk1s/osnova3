package com.example.workjugend.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.workjugend.R
import com.example.workjugend.databinding.DetailFragmentBinding
import com.example.workjugend.viewmodel.AdVIewModel

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
            binding.zarplata.text = getString(R.string.zp, currentAd.Zarplata)
            binding.old.text = currentAd.Old
            binding.organization.text = currentAd.Organization
            binding.opet.text = currentAd.Opet
            binding.opisanie.text = currentAd.Opisanie
            binding.trebovania.text = currentAd.Trebovanie
            binding.sity.text = currentAd.Sity
            binding.adres.text = currentAd.Adres
            binding.namber.text = currentAd.Namber
            binding.grafikrabot.text = currentAd.Grafik

        }
    }
}