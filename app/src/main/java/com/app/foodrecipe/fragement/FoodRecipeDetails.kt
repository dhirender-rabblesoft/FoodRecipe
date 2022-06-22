package com.app.foodrecipe.fragement

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.adapter.PageAdapter
import com.app.foodrecipe.adapter.ReviewAdapter
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentFoodRecipeDetailsBinding
import com.app.foodrecipe.screens.AddReviewActivity
import com.app.foodrecipe.screens.CommonActivity
import com.app.foodrecipe.screens.CreateRecipeActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_food_recipe_details.view.*


class FoodRecipeDetails(val baseActivity: KotlinBaseActivity) : KotlinBaseFragment() {
    lateinit var binding: FragmentFoodRecipeDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFoodRecipeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        setClick()
        setReviewAdapter()

    }

    private fun setReviewAdapter() {
        val reviewAdapter = ReviewAdapter(Keys.FoodDetailReview) {

        }
        binding.rv10Review.adapter = reviewAdapter
    }


    private fun setClick() {

        binding.tvmyrecipemore.setOnClickListener {

            val bundle = Bundle()
            bundle.putString(Keys.FRAGMENT_FROM, Keys.RECIPE_DETAIL_REVIEW.toString())
            baselistener.openA(CommonActivity::class,bundle)

        }
        binding.loginbutton.setOnClickListener {
            baselistener.openA(AddReviewActivity::class)
        }

        binding.ivback.setOnClickListener {
            baseActivity.onBackPressed()
        }
//        binding.addTipsTrickbutton.setOnClickListener {
//            baseActivity.openA(AddReviewActivity::class)
//        }
        binding.tvdotmenu.setOnClickListener {
            val popupMenu = PopupMenu(requireContext(), it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.edit -> {
                        baseActivity.openA(CreateRecipeActivity::class)
                        true
                    }
                    R.id.like -> {
                        Log.e("454555555555", "1111111")
                        true
                    }
                    R.id.share -> {
                        Log.e("454555555555", "2222222222")
                        true
                    }

                    else -> {
                        false
                    }
                }

            }
            popupMenu.inflate(R.menu.menu)
            popupMenu.show()


        }

        binding.ivediticon.setOnClickListener {
            baseActivity.openA(CreateRecipeActivity::class)
        }
//        binding.fbEditRecipe.setOnClickListener {
//            baseActivity.openA(CreateRecipeActivity::class)
//        }

    }


    private fun setAdapter() {
        binding.viewPager.adapter = PageAdapter(baseActivity)
        TabLayoutMediator(binding.tablayout, binding.viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> {
                    "Recipe"
                }
                1 -> {
                    "Ingredient"
                }
                else -> {
                    throw Resources.NotFoundException("Position Not found")
                }

            }

        }.attach()
    }


}