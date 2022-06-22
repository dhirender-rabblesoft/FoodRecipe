package com.app.foodrecipe.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.app.foodrecipe.R
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.databinding.ActivityAddReviewBinding
import com.app.foodrecipe.extension.invisible


class AddReviewActivity : KotlinBaseActivity() {
    lateinit var binding: ActivityAddReviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        setRatingbar()
        setClick()
    }

    private fun validation(): Boolean {
        binding.textarealayout.error = null

        if (binding.ettextarea.text.toString().isEmpty()) {
            binding.textarealayout.error = getString(R.string.valid_review)
            return false
        }
        if (binding.tvratingcount.text.toString().equals("0.0")){
            Toast.makeText(this,"Please give star ",Toast.LENGTH_LONG).show()
            return false
        }
        return true

    }

    private fun setRatingbar() {
        binding.userRating.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                val rating: Float = binding.userRating.getRating()
                Log.e("234234324324", rating.toString())
                binding.tvratingcount.setText(rating.toString())
                return binding.userRating.onTouchEvent(event)
            }
        })
    }

    private fun setToolbar() {
        binding.toolbar.tvtitle.setText("Add Review")
        binding.toolbar.menuIcon.setImageResource(R.drawable.back_arrow)
        binding.toolbar.filterIcon.invisible()
        binding.toolbar.menuIcon.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setClick() {
        binding.loginbutton.setOnClickListener {
            if (validation()){

                onBackPressed()
            }

        }
    }
}