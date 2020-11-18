package com.example.instagram_btm_nav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.instagram_btm_nav.Fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = home_Fragment()
        val reelsFragment=reels_Fragment()
        val photosFragment = photos_Fragment()
        val heartFragment= heart_Fragment()
        val profileFragment = profile_Fragment()

        current(homeFragment)

        btm_nav.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.home -> current(homeFragment)
                R.id.reels ->current(reelsFragment)
                R.id.photos ->current(photosFragment)
                R.id.heart-> current(heartFragment)
                else -> current(profileFragment)
            }
            true

        }


    }

    private fun current(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_host,fragment)
            commit()
        }
    }
}