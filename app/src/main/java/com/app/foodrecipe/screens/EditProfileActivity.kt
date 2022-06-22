package com.app.foodrecipe.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.app.foodrecipe.R
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.databinding.ActivityEditProfileBinding
import com.app.foodrecipe.extension.gone
import com.app.foodrecipe.extension.invisible

class EditProfileActivity : KotlinBaseActivity() {
    lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLevelDropDown()
        setToolbar()
    }

    private fun setToolbar() {
        binding.toolbar.menuIcon.setImageResource(R.drawable.back_arrow)
        binding.toolbar.tvtitle.setText("Edit Profile")
        binding.toolbar.filterIcon.invisible()
        binding.toolbar.menuIcon.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setLevelDropDown() {
        val levels = resources.getStringArray(R.array.chief_level)
        val levelAdapter = ArrayAdapter(this, R.layout.dropdown_item, levels)
        binding.etlevel.setAdapter(levelAdapter)
    }
}