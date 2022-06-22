package com.app.foodrecipe.fragement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.adapter.MyRecipeAdapter
import com.app.foodrecipe.adapter.PopularRecipeAdapter
import com.app.foodrecipe.adapter.TipsTicksAdapter
 import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentProfileFragementBinding
import com.app.foodrecipe.extension.gone
import com.app.foodrecipe.extension.visible
import com.app.foodrecipe.model.TipsTrickModel
import com.app.foodrecipe.screens.CommonActivity
import com.app.foodrecipe.screens.CreateRecipeActivity
import com.app.foodrecipe.screens.EditProfileActivity
import com.app.foodrecipe.screens.MyRecipeListingActivity
import kotlinx.android.synthetic.main.common_toolbar.view.*


class ProfileFragement : KotlinBaseFragment() {
    lateinit var binding: FragmentProfileFragementBinding
    var listoftips = ArrayList<TipsTrickModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileFragementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setPopularAdapter()
        setTodayPopularAdapter()
        setToolbar()
        setTipsTrcikAdapter()
        setClick()
    }

    private fun setTipsTrcikAdapter() {
        listoftips = ArrayList<TipsTrickModel>()
        listoftips.add(
            TipsTrickModel(
                "Reduce Sault In Food",
                "Potato",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
                "4.5",
                5,
                true
            )
        )
        listoftips.add(
            TipsTrickModel(
                "Make Chicken Tasty",
                "Onion",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
                "3.5",
                100,
                false
            )
        )
        listoftips.add(
            TipsTrickModel(
                "Make Food more delicious",
                "Jeera",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
                "2.5",
                2000,
                false
            )
        )
        val tipsTrickAdapter = TipsTicksAdapter() {
            val bundle = Bundle()
            bundle.putString(Keys.FRAGMENT_FROM, Keys.FRAGMENT_TIPS_TRICK_DETAIL.toString())
            baselistener.openA(CommonActivity::class, bundle)

        }
        binding.rvMyTips.adapter = tipsTrickAdapter
        tipsTrickAdapter.addNewList(listoftips)

    }


    private fun setToolbar() {
        val toolbar = requireActivity().findViewById<View>(R.id.toolbar)
        toolbar.tvtitle.setText("Profile")
        toolbar.filter_icon.gone()
        toolbar.filter_icon2.visible()
        toolbar.filter_icon2.setOnClickListener {
            baselistener.openA(EditProfileActivity::class)
        }
    }

    private fun setClick() {
        binding.createrecipecontainer.setOnClickListener {
            baselistener.openA(CreateRecipeActivity::class)
        }
        binding.tvmyrecipemore.setOnClickListener {
            baselistener.openA(MyRecipeListingActivity::class)
        }
        binding.tvmytipsviewmore.setOnClickListener {
            val bundle  = Bundle()
            bundle.putString(Keys.FRAGMENT_FROM,Keys.FRAGMENT_MY_TIPS_TRICK_LISTING.toString())
            baselistener.openA(CommonActivity::class,bundle)
        }

    }


    fun setTodayPopularAdapter() {
        val puplarAdapter = MyRecipeAdapter() {

        }
        binding.rvTodayPopular.adapter = puplarAdapter
    }

    fun setPopularAdapter() {
        val todayPopularAdapter = PopularRecipeAdapter() {

        }
        binding.rvPopularRecipe.adapter = todayPopularAdapter
    }


}