package com.app.foodrecipe.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.NumberPicker
import com.app.foodrecipe.R
import com.app.foodrecipe.adapter.CreateRecipeImageClickAdapter
import com.app.foodrecipe.adapter.IngredientAddAdapter
import com.app.foodrecipe.adapter.ShowAddRecipeStepsAdapter
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.databinding.ActivityCreateRecipeBinding
import com.app.foodrecipe.extension.invisible
import kotlinx.android.synthetic.main.activity_create_recipe.*

class CreateRecipeActivity : KotlinBaseActivity() {
    lateinit var binding: ActivityCreateRecipeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        setTimeAdapter()
        setMeasureIngredientAdapter()
        recipeImageClickAdapter()
        ingredientAddAdapter()
        showAddRecipeStepAdapter()

    }

    private fun setToolbar() {
        binding.toolbar.menuIcon.setImageResource(R.drawable.back_arrow)
        binding.toolbar.tvtitle.setText("Create Recipe")
        binding.toolbar.filterIcon.invisible()
        binding.toolbar.menuIcon.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setTimeAdapter() {
        val foodtimearrays = resources.getStringArray(R.array.food_time_array)
        var timeadapter = ArrayAdapter(this, R.layout.dropdown_item, foodtimearrays)
        binding.ettime.setAdapter(timeadapter)
    }

    private fun setMeasureIngredientAdapter() {
        val measureIngredientarrys = resources.getStringArray(R.array.ingredient_measure_array)
        var measureAdapter = ArrayAdapter(this, R.layout.dropdown_item, measureIngredientarrys)
        binding.etmeasire.setAdapter(measureAdapter)
    }

    private fun recipeImageClickAdapter() {
        val recipeClickAdapter = CreateRecipeImageClickAdapter() {

        }
        binding.rvImageclick.adapter = recipeClickAdapter
    }

    private fun ingredientAddAdapter() {
        val ingredientAddAdapter = IngredientAddAdapter() {

        }
        binding.rvShowIngredientAdd.adapter = ingredientAddAdapter
    }

    private fun showAddRecipeStepAdapter() {
        val showAddRecipeAdaper = ShowAddRecipeStepsAdapter() {

        }
        binding.rvShowAddRecipeStep.adapter = showAddRecipeAdaper
    }


}