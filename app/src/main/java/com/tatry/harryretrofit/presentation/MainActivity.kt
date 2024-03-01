package com.tatry.harryretrofit.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tatry.harryretrofit.R
import com.tatry.harryretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)

        binding.bottomNav.setupWithNavController(navController)
    }


    override fun onNavigateUp(): Boolean {
        navController = (supportFragmentManager.findFragmentById(R.id.fragment_container)
                as NavHostFragment).navController
        return navController.navigateUp() || super.onNavigateUp()

    }

}