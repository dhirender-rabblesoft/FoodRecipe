package com.app.foodrecipe.fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.adapter.FavouriteTipsTrickAdapter
import com.app.foodrecipe.adapter.TipsTicksAdapter
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentFavTipsBinding
import com.app.foodrecipe.model.TipsTrickModel
import com.app.foodrecipe.screens.CommonActivity

class FavTipsFragment : KotlinBaseFragment() {
    lateinit var binding: FragmentFavTipsBinding
    var listoftips = ArrayList<TipsTrickModel>()
    lateinit var favouriteTipsTrickAdapter: FavouriteTipsTrickAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavTipsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTipsTrcikAdapter()
    }


    private fun setTipsTrcikAdapter() {

        favouriteTipsTrickAdapter = FavouriteTipsTrickAdapter() {


        }
        binding.rvTipTrick.adapter = favouriteTipsTrickAdapter


    }
}