package com.app.foodrecipe.fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
 import com.app.foodrecipe.adapter.FavouriteRecipeAdapter
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentFavRecipeBinding
import com.app.foodrecipe.screens.CommonActivity


class FavRecipeFragment : KotlinBaseFragment() {
    lateinit var binding: FragmentFavRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFavouriteAdapter()
    }

    private fun setFavouriteAdapter() {
        val favouriteAdapter = FavouriteRecipeAdapter() {
            val bundle = Bundle()
            bundle.putString(Keys.FRAGMENT_FROM, Keys.FRAGMENT_TODAY_POPULAR_RECIPE.toString())
            baselistener.openA(CommonActivity::class, bundle)
        }
        binding.rvfavfoodlist.adapter = favouriteAdapter
    }

}