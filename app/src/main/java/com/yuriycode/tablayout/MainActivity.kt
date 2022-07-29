package com.yuriycode.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yuriycode.tablayout.adapter.PagerAdapter
import com.yuriycode.tablayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()
    }

    private fun initial() {
        binding.viewPager.adapter = PagerAdapter(this)
        binding.tabLayout.tabIconTint = null  //color of icons in the bottom
        TabLayoutMediator(binding.tabLayout, binding.viewPager){
            tab, pos ->
            when(pos){
                0 -> {
                    tab.setIcon(R.drawable.ic_baseline_account_circle_24)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.orange))
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_baseline_analytics_24)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.grey))
                    tab.icon?.alpha = 70
                }
                2-> {
                    tab.setIcon(R.drawable.ic_baseline_account_balance_24)
                    tab.icon?.setTint(ContextCompat.getColor(this, R.color.black))
                    tab.icon?.alpha = 70
                }
            }
        }.attach()
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.icon?.alpha = 250
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon?.alpha = 70
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }
}