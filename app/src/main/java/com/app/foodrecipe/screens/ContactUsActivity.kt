package com.app.foodrecipe.screens

import android.os.Bundle
import com.app.foodrecipe.R
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.databinding.ActivityContactUsBinding
import com.app.foodrecipe.extension.invisible
import com.app.foodrecipe.extension.isEmailValid

class ContactUsActivity : KotlinBaseActivity() {
    lateinit var binding: ActivityContactUsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        setClick()
    }

    private fun setToolbar() {
        binding.toolbar.menuIcon.setImageResource(R.drawable.back_arrow)
        binding.toolbar.filterIcon.invalidate()
        binding.toolbar.tvtitle.setText("Contact Us")
        binding.toolbar.filterIcon.invisible()
        binding.toolbar.menuIcon.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setClick() {
        binding.loginbutton.setOnClickListener {
            if (validation()) {
                customSnackBar("Contact us Submit Button Click", false)
            }
        }
    }

    private fun validation(): Boolean {
        binding.namelayout.error = null
        binding.emaillayout.error = null
        binding.textarealayout.error = null

        if (binding.etusername.text.toString().isEmpty()) {
            binding.namelayout.error = getString(R.string.v_name)
            return false
        }
        if (binding.etemail.text.toString().isEmpty()) {
            binding.emaillayout.error = getString(R.string.v_emailvalidation)
            return false
        }
        if (!isEmailValid(binding.etemail.text.toString())) {
            binding.emaillayout.error = getString(R.string.v_validemail)
            return false
        }
        if (binding.ettextarea.text.toString().isEmpty()) {
            binding.textarealayout.error = getString(R.string.v_query)
            return false
        }
        return true
    }


    //Contact Us Api
    private fun contactUsApi(){

    }
}