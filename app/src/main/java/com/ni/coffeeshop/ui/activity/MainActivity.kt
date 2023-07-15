package com.ni.coffeeshop.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ni.coffeeshop.databinding.MainActivityBinding
import com.ni.coffeeshop.ui.common.FragmentHelper
import com.ni.coffeeshop.ui.screens.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val activity = this
        FragmentHelper.loadFragment(
            activity,
            HomeFragment.newInstance(),
            "",
            binding.flFragmentContainer.id
        )
    }
}