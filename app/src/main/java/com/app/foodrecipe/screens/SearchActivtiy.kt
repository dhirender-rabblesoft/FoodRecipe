package com.app.foodrecipe.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.Utils.Utils
import com.app.foodrecipe.adapter.PopularRecipeAdapter
import com.app.foodrecipe.adapter.SearchRecipeAdapter
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.databinding.ActivitySearchActivtiyBinding
import com.app.foodrecipe.extension.invisible
import com.app.foodrecipe.extension.isNotNull
import com.app.foodrecipe.model.AddFoodRecipe
import com.bumptech.glide.util.Util

class SearchActivtiy : KotlinBaseActivity() {
    lateinit var binding: ActivitySearchActivtiyBinding
    var bundle = Bundle()
    lateinit var todayPopularAdapter : SearchRecipeAdapter
    val searchArrayList = ArrayList<AddFoodRecipe>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchActivtiyBinding.inflate(layoutInflater)
        bundle = intent.extras!!
        val firstKeyword = bundle.getString(Keys.SEARCH_KEYWORD)
        binding.searchBar.edsearchtext.setText(firstKeyword)
        setContentView(binding.root)
        setPopularAdapter()
        searchBar()
        setToolbar()
        setSearch()



    }
    private fun setSearch(){
        if (searchArrayList.isNotEmpty()){
            val keyword = binding.searchBar.edsearchtext.text.toString()
            val searchtemplist = ArrayList<AddFoodRecipe>()
            searchArrayList.forEach {
                if (it.recipeName.lowercase().contains(keyword.lowercase())){
                    searchtemplist.clear()
                    searchtemplist.add(it)
                    if (keyword.isEmpty()){
                        todayPopularAdapter.addNewList(searchArrayList)
                    }else{
                        todayPopularAdapter.addNewList(searchtemplist)
                    }
                    todayPopularAdapter.notifyDataSetChanged()

                }
            }
        }
    }

    private fun setToolbar() {
        binding.toolbar.menuIcon.setImageResource(R.drawable.back_arrow)
        binding.toolbar.tvtitle.setText("Search Recipe")
        binding.toolbar.filterIcon.invisible()
        binding.toolbar.menuIcon.setOnClickListener {
            onBackPressed()
        }
    }


    private fun searchBar() {
        binding.searchBar.edsearchtext.setOnEditorActionListener(TextView.OnEditorActionListener { view, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                Utils.hideKeyBoard(this,view)
                setSearch()
            }

            false
        })
    }

    fun setPopularAdapter() {
        searchArrayList.add(AddFoodRecipe("Ram Laddu","this is a description",100,2.5f,1000L,15))
        searchArrayList.add(AddFoodRecipe("Kadai paneer ","Paneer and green peppers in tomato gravy",500,4.5f,1000L,45))
        searchArrayList.add(AddFoodRecipe("Kadhi pakoda","Gram flour with yogurt with gramflour fried balls",100,2.5f,1000L,15))
        searchArrayList.add(AddFoodRecipe("Karela bharta","a bitter gourd or melon dish",300,6.5f,1000L,90))
        searchArrayList.add(AddFoodRecipe("Katha meetha petha / kaddu halwa","Pumpkin cooked in spices",100,2.5f,1000L,15))
        searchArrayList.add(AddFoodRecipe("Ram Laddu","this is a description",1000,2.5f,1000L,15))
        searchArrayList.add(AddFoodRecipe("Kadai paneer ","Paneer and green peppers in tomato gravy",500,4.5f,1000L,45))
        searchArrayList.add(AddFoodRecipe("Kadhi pakoda","Gram flour with yogurt with gramflour fried balls",100,2.5f,1000L,15))
        searchArrayList.add(AddFoodRecipe("Karela bharta","a bitter gourd or melon dish",30000,6.5f,1000L,90))
        searchArrayList.add(AddFoodRecipe("Katha meetha petha / kaddu halwa","Pumpkin cooked in spices",100,2.5f,1000L,15))
        searchArrayList.add(AddFoodRecipe("Ram Laddu","this is a description",100,2.5f,1000L,15))
        searchArrayList.add(AddFoodRecipe("Kadai paneer ","Paneer and green peppers in tomato gravy",500,4.5f,1000L,45))
        searchArrayList.add(AddFoodRecipe("Kadhi pakoda","Gram flour with yogurt with gramflour fried balls",100,2.5f,1000L,15))
        searchArrayList.add(AddFoodRecipe("Karela bharta","a bitter gourd or melon dish",300,6.5f,1000L,90))
        searchArrayList.add(AddFoodRecipe("Katha meetha petha / kaddu halwa","Pumpkin cooked in spices",100,2.5f,1000L,15))

          todayPopularAdapter = SearchRecipeAdapter() {
        }
        binding.rvSearch.adapter = todayPopularAdapter
        todayPopularAdapter.addNewList(searchArrayList)
    }


}