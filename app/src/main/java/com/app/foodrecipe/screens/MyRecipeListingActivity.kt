package com.app.foodrecipe.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.foodrecipe.R
import com.app.foodrecipe.adapter.MyRecipeAdapter
import com.app.foodrecipe.databinding.ActivityMyRecipeListingBinding
import com.app.foodrecipe.extension.invisible

class MyRecipeListingActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyRecipeListingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyRecipeListingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        setMyRecipeListing()
    }

    private fun setToolbar() {
        binding.toolbar.menuIcon.setImageResource(R.drawable.back_arrow)
        binding.toolbar.tvtitle.setText("My Recipe's")
        binding.toolbar.filterIcon.invisible()
        binding.toolbar.menuIcon.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setMyRecipeListing() {
        val myRecipeAdapter = MyRecipeAdapter() {

        }
        binding.rvMyrecipeListing.adapter = myRecipeAdapter
    }
}