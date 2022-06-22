package com.app.foodrecipe.fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.foodrecipe.R
import com.app.foodrecipe.adapter.IngredientDetailAdapter
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentIngredientBinding

class IngredientFragment : KotlinBaseFragment() {
    lateinit var binding: FragmentIngredientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIngredientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setIngredientAdapter()
    }

    private fun setIngredientAdapter() {
        val ingredientAdapter = IngredientDetailAdapter() {

        }
        binding.rvIngredient.adapter = ingredientAdapter
    }

}