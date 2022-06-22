package com.app.foodrecipe.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.adapter.MyRecipeAdapter
import com.app.foodrecipe.adapter.ReviewAdapter
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.ActivityTopChefBinding
import com.app.foodrecipe.fragement.MyTipsTrickListingFragment

class TopChefActivity : KotlinBaseActivity() {
    lateinit var binding: ActivityTopChefBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopChefBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setChefRecipeAdapter()
        setChefReviewAdpater()
        setClick()
    }

    private fun setChefRecipeAdapter() {
        val chefAdapter = MyRecipeAdapter() {

        }
        binding.rvChefRecipes.adapter = chefAdapter
    }

    private fun setChefReviewAdpater() {
        val chefReviewAdapter = ReviewAdapter(Keys.TOP_CHEF_REVIEW) {
        }
        binding.rvChefReview.adapter = chefReviewAdapter

    }

    private fun setClick() {
        binding.ivback.setOnClickListener {
            onBackPressed()
        }
        binding.tvmyrecipemore.setOnClickListener {
            openA(MyRecipeListingActivity::class)
        }
        binding.tvchefreviewMore.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(Keys.FRAGMENT_FROM, Keys.RECIPE_DETAIL_REVIEW.toString())
            openA(CommonActivity::class, bundle)
        }
    }
}