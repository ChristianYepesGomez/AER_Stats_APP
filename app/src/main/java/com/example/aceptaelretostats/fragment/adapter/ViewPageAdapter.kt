package com.example.aceptaelretostats.fragment.adapter

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aceptaelretostats.fragment.InstitutionsFragment
import com.example.aceptaelretostats.fragment.ProblemsFragment
import com.example.aceptaelretostats.fragment.UsersFragment

class ViewPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> UsersFragment()
            1 -> InstitutionsFragment()
            else -> ProblemsFragment()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}