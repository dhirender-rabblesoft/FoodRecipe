package com.app.foodrecipe.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.foodrecipe.R
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.ActivityAddTipsTrickBinding
import com.app.foodrecipe.extension.invisible

class AddTipsTrickActivity : KotlinBaseActivity() {
    lateinit var binding: ActivityAddTipsTrickBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTipsTrickBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        setClikc()
    }

    private fun setToolbar() {
        binding.toolbar.tvtitle.setText("Add Tips Trick")
        binding.toolbar.filterIcon.invisible()
        binding.toolbar.menuIcon.setImageResource(R.drawable.back_arrow)
        binding.toolbar.menuIcon.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setClikc() {
        binding.loginbutton.setOnClickListener {

        }
    }
}