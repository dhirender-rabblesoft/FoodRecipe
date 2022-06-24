package com.app.foodrecipe.fragement

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.foodrecipe.R
import com.app.foodrecipe.adapter.FavPageAdapter
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentFavouriteFragementBinding
import com.app.foodrecipe.extension.gone
import com.app.foodrecipe.extension.invisible
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.common_toolbar.view.*


class FavouriteFragement : KotlinBaseFragment() {
    lateinit var binding: FragmentFavouriteFragementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavouriteFragementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()
        setFavouriteAdapter()
    }

    private fun setToolbar() {
        val toolbar = requireActivity().findViewById<View>(R.id.toolbar)
        toolbar.tvtitle.setText("Favourite")
        toolbar.filter_icon.invisible()
        toolbar.filter_icon2.gone()

    }

    private fun setFavouriteAdapter() {
        binding.viewpager.adapter = FavPageAdapter(requireActivity())
        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, index ->
            tab.text = when (index) {
                0 -> "Recipe"
                1 -> "Tips Tricks"
                else -> throw Resources.NotFoundException("Position Not Found")
            }
        }.attach()
    }

}