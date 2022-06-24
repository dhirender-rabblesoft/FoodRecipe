package com.app.foodrecipe.fragement

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.adapter.NewRecipeAdapter
import com.app.foodrecipe.adapter.PopularRecipeAdapter
import com.app.foodrecipe.adapter.TodayPopularAdapter
import com.app.foodrecipe.adapter.TopUserTodayAdapter
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentHomeScreenFragementBinding
import com.app.foodrecipe.extension.gone
import com.app.foodrecipe.extension.visible
import com.app.foodrecipe.screens.CommonActivity
import com.app.foodrecipe.screens.SearchActivtiy
import com.app.foodrecipe.screens.TopChefActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.common_toolbar.view.*


class HomeScreenFragment() : KotlinBaseFragment() {
    lateinit var binding: FragmentHomeScreenFragementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeScreenFragementBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClicks()
        setPopularAdapter()
        setNewRecipeAdapter()
        setTodayPopularAdapter()
        setTopUserAdapter()
        setToolbar()

    }

    private fun setToolbar() {
        val toolbar = requireActivity().findViewById<View>(R.id.toolbar)
        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        toolbar.filter_icon.visible()
        toolbar.filter_icon2.gone()
        toolbar.filter_icon.setImageResource(R.drawable.chef_profile)
        toolbar.tvtitle.setText("Browse")

        toolbar.filter_icon.setOnClickListener {
            bottomNavigationView.selectedItemId = R.id.profileFragement
        }

//        //open filter dailog box
//        toolbar.filter_icon.setOnClickListener {
//            val dailog = FilterDailog(){
//
//            }
//            dailog.show(requireActivity().supportFragmentManager,dailog.tag)
//        }
    }

    private fun setClicks() {
         binding.searchbar.edsearchtext.setOnEditorActionListener(OnEditorActionListener { view, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val bundle = Bundle()
                bundle.putString(Keys.SEARCH_KEYWORD,view.text.toString())
                baselistener.openA(SearchActivtiy::class,bundle)
                return@OnEditorActionListener true
            }
            false
        })

    }


    fun setTodayPopularAdapter() {
        val puplarAdapter = TodayPopularAdapter() {
            val bundle = Bundle()
            bundle.putString(Keys.FRAGMENT_FROM, Keys.FRAGMENT_TODAY_POPULAR_RECIPE.toString())
            baselistener.openA(CommonActivity::class, bundle)

        }
        binding.rvTodayPopular.adapter = puplarAdapter
    }

    fun setTopUserAdapter() {
        val topUserTodayAdapter = TopUserTodayAdapter() {

            baselistener.openA(TopChefActivity::class)


        }
        binding.rvTopUser.adapter = topUserTodayAdapter

    }

    fun setNewRecipeAdapter() {
        val newRecipeAdapter = NewRecipeAdapter() {
            val bundle = Bundle()
            bundle.putString(Keys.FRAGMENT_FROM, Keys.FRAGMENT_NEW_RECIPE.toString())
            baselistener.openA(CommonActivity::class, bundle)
        }
        binding.rvNewRecipe.adapter = newRecipeAdapter
    }

    fun setPopularAdapter() {
        val todayPopularAdapter = PopularRecipeAdapter() {
            val bundle = Bundle()
            bundle.putString(Keys.FRAGMENT_FROM, Keys.FRAGMENT_POUPAR_RECIPE.toString())
            baselistener.openA(CommonActivity::class, bundle)

        }
        binding.rvPopularRecipe.adapter = todayPopularAdapter
    }


//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }

}