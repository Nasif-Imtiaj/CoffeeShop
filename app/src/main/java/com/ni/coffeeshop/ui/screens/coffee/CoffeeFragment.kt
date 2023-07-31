package com.ni.coffeeshop.ui.screens.coffee

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.fragment.app.Fragment
import com.ni.coffeeshop.databinding.FragmentCoffeeBinding

class CoffeeFragment : Fragment() {

    companion object {
        fun newInstance() = CoffeeFragment()
    }

    private lateinit var binding: FragmentCoffeeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoffeeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                 popFragment()
            }
        })
    }

    fun popFragment(){
        try {
            requireActivity().supportFragmentManager.popBackStack()
        } catch (ex: Exception) {
        }

    }
}