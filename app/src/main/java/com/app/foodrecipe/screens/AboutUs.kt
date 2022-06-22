package com.app.foodrecipe.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.foodrecipe.R
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.databinding.ActivityAboutUsBinding
import com.app.foodrecipe.extension.invisible

class AboutUs : KotlinBaseActivity() {
    lateinit var binding: ActivityAboutUsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
    }

    private fun setToolbar() {
        binding.toolbar.menuIcon.setImageResource(R.drawable.back_arrow)
        binding.toolbar.filterIcon.invisible()
        binding.toolbar.tvtitle.setText("About Us")
        binding.toolbar.menuIcon.setOnClickListener {
            onBackPressed()
        }
    }
}
