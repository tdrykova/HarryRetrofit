package com.tatry.harryretrofit.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.tatry.harryretrofit.R
import com.tatry.harryretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // без библиотеки для фрагментов
//        supportFragmentManager.beginTransaction().replace(
//            R.id.fragment_container,
//            MainFragment()
//        ).commit()

        // с библиотекой
        supportFragmentManager.commit {
//            val fragment = MainFragment()
            val fragment = MainFragment.newInstance("custom from main activity")
            replace(R.id.fragment_container, fragment)
            addToBackStack(MainFragment::class.java.simpleName)
        }
    }


}