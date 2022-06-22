package com.app.foodrecipe.fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.adapter.TipsTicksAdapter
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentMyTipsTrickListingBinding
import com.app.foodrecipe.databinding.FragmentProfileFragementBinding
import com.app.foodrecipe.extension.invisible
import com.app.foodrecipe.screens.AddTipsTrickActivity
import com.app.foodrecipe.screens.CommonActivity


class MyTipsTrickListingFragment(val baseActivity: KotlinBaseActivity) : KotlinBaseFragment() {

    lateinit var binding: FragmentMyTipsTrickListingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyTipsTrickListingBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTipsTrcikAdapter()
        setToolbar()
        setClick()

    }

    private fun setToolbar() {
        binding.toolbar.menuIcon.setImageResource(R.drawable.back_arrow)
        binding.toolbar.tvtitle.setText("My Tip Tricks")
        binding.toolbar.filterIcon.invisible()
        binding.toolbar.menuIcon.setOnClickListener {
            baseActivity.onBackPressed()
        }
    }

    private fun setClick() {
        binding.addTipsTrickbutton.setOnClickListener {
            baseActivity.openA(AddTipsTrickActivity::class)
        }
    }


    private fun setTipsTrcikAdapter() {
        val tipsTrickAdapter = TipsTicksAdapter() {


        }
        binding.rvTipTrick.adapter = tipsTrickAdapter

    }

}