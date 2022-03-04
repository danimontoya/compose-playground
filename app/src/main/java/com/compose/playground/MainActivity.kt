package com.compose.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.compose.playground.masterdetail.MasterDetailFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MasterDetailFragment.newInstance())
                .commitNow()
        }
    }
}
