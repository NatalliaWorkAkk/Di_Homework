package com.effectivemobile.dihomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.effectivemobile.faeture_home.presentation.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment())
            .commit()
    }
}