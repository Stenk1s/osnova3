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
            binding.old.text = getString(R.string.old, currentAd.Old)
            binding.organization.text = getString(R.string.org, currentAd.Organization)
            binding.opet.text = getString(R.string.opet, currentAd.Opet)
            binding.opisanie.text = getString(R.string.opisanie, currentAd.Opisanie)
            binding.trebovania.text = getString(R.string.trebovania, currentAd.Trebovanie)
            binding.sity.text = getString(R.string.city, currentAd.Sity)
            binding.adres.text = getString(R.string.adres, currentAd.Adres)
            binding.namber.text = getString(R.string.nomer, currentAd.Namber)
            binding.grafikrabot.text = getString(R.string.grafik, currentAd.Grafik)

        }
    }
}