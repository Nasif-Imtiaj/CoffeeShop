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

        fun loadFragment(
            activity: AppCompatActivity,
            newFragment: Fragment,
            addToBackStack: Boolean = true,
            clearBackStack: Boolean = false,
            tag: String,
            container: Int,
        ) {
            try {
                val mFragmentManager: FragmentManager = activity.supportFragmentManager
                if (clearBackStack) {
                    if (mFragmentManager.isStateSaved) {
                        return
                    }
                    mFragmentManager.popBackStackImmediate(
                        null,
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )
                }
                val fragmentTransaction =
                    mFragmentManager.beginTransaction()
                fragmentTransaction.add(
                    container,
                    newFragment,
                    tag
                )
                if (addToBackStack) fragmentTransaction.addToBackStack(tag)
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
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