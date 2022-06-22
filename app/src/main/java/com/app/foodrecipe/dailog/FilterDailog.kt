package com.app.foodrecipe.dailog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.app.foodrecipe.R
import com.app.foodrecipe.adapter.CookingTimeFilterAdapter
import com.app.foodrecipe.adapter.FoodCategoryFilterAdapter
import com.app.foodrecipe.adapter.FoodTypeFilterAdapter
import com.app.foodrecipe.base.DialogBaseFragment
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.databinding.FragmentFilterDailogBinding


class FilterDailog(val itemClick: (Int) -> Unit) : DialogBaseFragment(), View.OnClickListener {

    lateinit var binding: FragmentFilterDailogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFilterDailogBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setFilterFoodTime()
        setFilterFoodCateogory()
        setTimeAdapter()
        setClick()
//        setFilterFoodType()
    }

    private fun setClick() {
        binding.llcancelcoantiner.setOnClickListener(this)
    }


    private fun setTimeAdapter() {
        val foodtimearrays = resources.getStringArray(R.array.food_time_array)
        var timeadapter = ArrayAdapter(requireActivity(), R.layout.dropdown_item, foodtimearrays)
        binding.ettime.setAdapter(timeadapter)
    }

//    private fun setFilterFoodType() {
//        val foodTypeFilterAdapter = FoodTypeFilterAdapter() {
//
//        }
//        binding.rvfilterfoodtype.adapter = foodTypeFilterAdapter
//    }

    private fun setFilterFoodCateogory() {
        val foodCategoryFilterAdapter = FoodCategoryFilterAdapter() {

        }
        binding.rvfilterfoodCategory.adapter = foodCategoryFilterAdapter
    }

//    private fun setFilterFoodTime() {
//        val cookingTimeFilterAdapter = CookingTimeFilterAdapter() {
//
//        }
//
//        binding.rvfilterCookingTime.adapter = cookingTimeFilterAdapter
//    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.llcancelcoantiner -> {
                dismiss()
            }
        }
    }


}