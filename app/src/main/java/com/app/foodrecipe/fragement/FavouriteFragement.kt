package com.app.foodrecipe.fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.adapter.FavouriteAdapter
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentFavouriteFragementBinding
import com.app.foodrecipe.databinding.FragmentTipsTrickFragementBinding
import com.app.foodrecipe.extension.gone
import com.app.foodrecipe.extension.invisible
import com.app.foodrecipe.screens.CommonActivity
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
        setFavouriteAdapter()
        setToolbar()
    }

    private fun setToolbar() {
        val toolbar = requireActivity().findViewById<View>(R.id.toolbar)
        toolbar.tvtitle.setText("Favourite")
        toolbar.filter_icon.invisible()
        toolbar.filter_icon2.gone()

    }

    private fun setFavouriteAdapter() {
        val favouriteAdapter = FavouriteAdapter() {
            val bundle = Bundle()
            bundle.putString(Keys.FRAGMENT_FROM, Keys.FRAGMENT_TODAY_POPULAR_RECIPE.toString())
            baselistener.openA(CommonActivity::class,bundle)
        }
        binding.rvfavfoodlist.adapter = favouriteAdapter
    }

}