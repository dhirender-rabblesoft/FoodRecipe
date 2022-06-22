package com.app.foodrecipe.screens

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.app.foodrecipe.R
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.databinding.ActivityContainerAuthBinding


class AuthActivityContainer : KotlinBaseActivity() {

    lateinit var binding: ActivityContainerAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContainerAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        setClick()
    }

}