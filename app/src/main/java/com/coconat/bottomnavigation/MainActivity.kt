package com.coconat.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bn: BottomNavigationView = findViewById(R.id.bottomNavigation)


        loadFragment(HomeFragment())
       bn.setOnItemSelectedListener{view->
           when(view.itemId){
               R.id.nav_home->{
                   loadFragment(HomeFragment())
                   true
               }
               R.id.nav_about->{
                   loadFragment(AboutFragment())
                   true
               }
               R.id.nav_contact->{
                   loadFragment(ContactFragment())
                   true
               }else ->{
                   loadFragment(ProfileFragment())
                    true
               }
           }
       }

    }

    private fun loadFragment( fragment: Fragment ) {
        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.frameLayout, fragment)
//        if (flag) {
//         ft.add(R.id.frameLayout, fragment)
//        }else {
//         ft.replace(R.id.frameLayout, fragment)
//        }
            ft.commit()
    }
}