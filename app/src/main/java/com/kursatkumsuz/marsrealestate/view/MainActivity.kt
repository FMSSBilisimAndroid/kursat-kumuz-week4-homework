package com.kursatkumsuz.marsrealestate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kursatkumsuz.marsrealestate.R
import com.kursatkumsuz.marsrealestate.view.fragment.MarsFragmentFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var fragmentFactory : MarsFragmentFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = fragmentFactory
        setContentView(R.layout.activity_main)
    }
}