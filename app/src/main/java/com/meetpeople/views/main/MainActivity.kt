package com.meetpeople.views.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.meetpeople.R
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchPersons()

        lifecycleScope.launch {
            viewModel.persons.collect {
                Log.d("MainActivity", "persons size -> ${it?.size}")
            }
        }
    }
}