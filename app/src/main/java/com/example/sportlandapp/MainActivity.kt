package com.example.sportlandapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
            .setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.registerScreen -> findViewById<BottomNavigationView>(R.id.bottom_navigation).isVisible = false
                R.id.forma -> findViewById<BottomNavigationView>(R.id.bottom_navigation).isVisible = false
                R.id.inputScreen -> findViewById<BottomNavigationView>(R.id.bottom_navigation).isVisible = false
                R.id.newScreen -> findViewById<BottomNavigationView>(R.id.bottom_navigation).isVisible = false
            else -> findViewById<BottomNavigationView>(R.id.bottom_navigation).isVisible = true
            }
        }
    }
}