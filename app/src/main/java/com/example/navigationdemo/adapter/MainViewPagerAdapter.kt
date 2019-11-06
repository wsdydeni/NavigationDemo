package com.example.navigationdemo.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.navigationdemo.fragment.ContactFragment
import com.example.navigationdemo.fragment.FindFragment
import com.example.navigationdemo.fragment.HomeFragment
import com.example.navigationdemo.fragment.MineFragment
import java.lang.IndexOutOfBoundsException

/**
 * @description
 */
const val HOME_PAGE_INDEX = 0
const val CONTACT_PAGE_INDEX = 1
const val FIND_PAGE_INDEX = 2
const val MINE_PAGE_INDEX = 3
class MainViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val fragments : Map<Int, () -> Fragment> = mapOf(
        HOME_PAGE_INDEX to { HomeFragment() },
        CONTACT_PAGE_INDEX to { ContactFragment() },
        FIND_PAGE_INDEX to { FindFragment() },
        MINE_PAGE_INDEX to { MineFragment()}
    )

    override fun createFragment(position: Int): Fragment {
        return fragments[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

    override fun getItemCount(): Int = fragments.size

}