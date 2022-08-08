package com.ands.newstestapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ands.newstestapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

            //changes 1

        //changes 2
        //changes 22

    }

}