package com.ni.coffeeshop.ui.common

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class FragmentHelper : FragmentActivity() {
    companion object {
        fun loadFragment(
            activity: AppCompatActivity,
            newFragment: Fragment,
            tag: String,
            container: Int,
            enterTransition: Int = FragmentTransaction.TRANSIT_FRAGMENT_OPEN
        ) {
            try {
                val mFragmentManager: FragmentManager = activity.supportFragmentManager
                val fragmentTransaction =
                    mFragmentManager.beginTransaction()
                fragmentTransaction.add(
                    container,
                    newFragment,
                    tag
                )
                fragmentTransaction.setTransition(enterTransition)
                if (mFragmentManager.isStateSaved) {
                    fragmentTransaction.commitAllowingStateLoss()
                } else {
                    fragmentTransaction.commit()
                }
            } catch (ex: Exception) {
            }
        }
    }

}