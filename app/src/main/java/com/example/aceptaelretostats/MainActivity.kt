package com.example.aceptaelretostats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.aceptaelretostats.databinding.ActivityMainBinding
import com.example.aceptaelretostats.fragment.adapter.ViewPageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager2: ViewPager2
    lateinit var users: Retrofit
    private lateinit var binding: ActivityMainBinding
    private val adapter = ViewPageAdapter(supportFragmentManager, lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createTabs()
        users = getRetrofit()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("localhost:3000/getUsers")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun createTabs() {
        tabLayout = binding.tabLayout
        viewPager2 = binding.viewPager2
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Usuarios"
                    tab.setIcon(R.drawable.ic_baseline_person_24)

                }
                1 -> {
                    tab.text = "Instituciones"
                    tab.setIcon(R.drawable.ic_baseline_institution_24)
                }
                2 -> {
                    tab.text = "Problemas"
                    tab.setIcon(R.drawable.ic_list_24)
                }
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == R.id.shareBtn) {
            var shareIntent = Intent().apply {
                this.action = Intent.ACTION_SEND
                this.putExtra(Intent.EXTRA_TEXT, "Sharing")
                this.type = "text/plain"
            }
            startActivity(shareIntent)
        } else {
            return super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

}