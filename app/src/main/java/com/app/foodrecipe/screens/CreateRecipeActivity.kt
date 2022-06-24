package com.app.foodrecipe.screens

import android.app.Application
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.adapter.CreateRecipeImageClickAdapter
import com.app.foodrecipe.adapter.IngredientAddAdapter
import com.app.foodrecipe.adapter.ShowAddRecipeStepsAdapter
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.databinding.ActivityCreateRecipeBinding
import com.app.foodrecipe.extension.getMultiPart
import com.app.foodrecipe.extension.invisible
import com.app.foodrecipe.extension.isNotNull
import com.app.foodrecipe.model.AddIngredientModel
import com.app.foodrecipe.model.AddStepModel
import com.app.foodrecipe.repository.CommonRepository
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageView
import com.canhub.cropper.options
import com.google.gson.Gson
import com.permissionx.guolindev.PermissionX
import id.zelory.compressor.Compressor
import kotlinx.coroutines.async
import okhttp3.MultipartBody
import java.io.File


class CreateRecipeActivity : KotlinBaseActivity() {
    lateinit var binding: ActivityCreateRecipeBinding
    var arrayimg: ArrayList<File> = ArrayList<File>()
    lateinit var ingredientAddAdapter: IngredientAddAdapter
    lateinit var showAddRecipeAdaper: ShowAddRecipeStepsAdapter
    val arrayOfIngredient = ArrayList<AddIngredientModel>()
    val arrayOfStep = ArrayList<AddStepModel>()
    val commonRepository = CommonRepository(Application())

    lateinit var recipeClickAdapter: CreateRecipeImageClickAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        setTimeAdapter()
        setMeasureIngredientAdapter()
        setClick()


    }

    private fun setToolbar() {
        binding.toolbar.menuIcon.setImageResource(R.drawable.back_arrow)
        binding.toolbar.tvtitle.setText("Create Recipe")
        binding.toolbar.filterIcon.invisible()
        binding.toolbar.menuIcon.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setClick() {
        binding.foodimage.setOnClickListener {
            askPermission()
        }
        binding.addIngredientbutton.setOnClickListener {
            if (ingredientValidation()) {
                val ingredient_name = binding.etingredient.text.toString()
                val ingredient_quantity = binding.etingredientname.text.toString()
                val ingredient_unit = binding.etmeasire.text.toString()
                arrayOfIngredient.add(
                    AddIngredientModel(
                        ingredient_name,
                        ingredient_quantity,
                        ingredient_unit
                    )
                )
                ingredientAddAdapter()
                binding.etingredient.setText("")
                binding.etingredientname.setText("")
            }
        }
        binding.addstepbutton.setOnClickListener {
            if (stepsValidation()) {
                val stepTitle = binding.etAddStep.text.toString()
                val stepDes = binding.ettextarea.text.toString()
                arrayOfStep.add(AddStepModel(stepTitle, stepDes))
                showAddRecipeStepAdapter()
                binding.etAddStep.setText("")
                binding.ettextarea.setText("")
            }
        }
        binding.createRecipeButton.setOnClickListener {
            if (validation()) {

                customSnackBar("Create Recipe Button Click", false)

            }
        }
    }

    private fun ingredientValidation(): Boolean {
        binding.ingredientnamelayout.error = null
        binding.measurelayout.error = null
        binding.ingreadientlayout.error = null

        if (binding.etingredient.text.toString().isEmpty()) {
            binding.ingreadientlayout.error = getString(R.string.v_ingredient_name)
            return false
        }
        if (binding.etingredientname.text.toString().isEmpty()) {
            binding.ingredientnamelayout.error = getString(R.string.v_quantity)
            return false
        }
        if (binding.etmeasire.text.toString().isEmpty()) {
            binding.measurelayout.error = getString(R.string.v_measure_name)
        }
        return true

    }

    private fun stepsValidation(): Boolean {
        binding.addStepLayout.error = null
        binding.textarealayout.error = null
        if (binding.etAddStep.text.toString().isEmpty()) {
            binding.addStepLayout.error = getString(R.string.v_step_name)
            return false
        }
        if (binding.ettextarea.text.toString().isEmpty()) {
            binding.textarealayout.error = getString(R.string.v_step_des)
            return false

        }
        return true
    }

    private fun validation(): Boolean {
        binding.namelayout.error = null
        binding.timelayout.error = null
        binding.addStepLayout.error = null
        binding.ingreadientlayout.error = null


        if (binding.etname.text.toString().isEmpty()) {
            binding.namelayout.error = getString(R.string.v_recipe_name)
            return false
        }
        if (binding.ettime.text.toString().equals(getString(R.string.choose))) {
            binding.timelayout.error = getString(R.string.v_time)
            return false
        }
        if (arrayOfStep.isNullOrEmpty()) {
            binding.addStepLayout.error = getString(R.string.v_step_name)
            return false
        }

        if (arrayOfIngredient.isNullOrEmpty()) {
            binding.ingreadientlayout.error = getString(R.string.v_ingredient_name)
            return false

        }
        if (arrayimg.isNullOrEmpty()) {
            customSnackBar(getString(R.string.v_valid_recipe_img), true)
            return false

        }

        return true


    }

    private fun setTimeAdapter() {
        val foodtimearrays = resources.getStringArray(R.array.food_time_array)
        var timeadapter = ArrayAdapter(this, R.layout.dropdown_item, foodtimearrays)
        binding.ettime.setAdapter(timeadapter)
    }

    private fun setMeasureIngredientAdapter() {
        val measureIngredientarrys = resources.getStringArray(R.array.ingredient_measure_array)
        var measureAdapter = ArrayAdapter(this, R.layout.dropdown_item, measureIngredientarrys)
        binding.etmeasire.setAdapter(measureAdapter)
    }

    private fun recipeImageClickAdapter() {
        recipeClickAdapter = CreateRecipeImageClickAdapter() {
            arrayimg.removeAt(it)
            recipeClickAdapter.addNewList(arrayimg)
            recipeClickAdapter.notifyDataSetChanged()

        }
        binding.rvImageclick.adapter = recipeClickAdapter
        recipeClickAdapter.addNewList(arrayimg)

    }

    private fun ingredientAddAdapter() {


        val gridlayoutmanger = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rvShowIngredientAdd.layoutManager = gridlayoutmanger
        ingredientAddAdapter = IngredientAddAdapter() {
            arrayOfIngredient.removeAt(it)
            ingredientAddAdapter.addNewList(arrayOfIngredient)
            ingredientAddAdapter.notifyDataSetChanged()
        }
        binding.rvShowIngredientAdd.adapter = ingredientAddAdapter
        ingredientAddAdapter.addNewList(arrayOfIngredient)
    }

    private fun showAddRecipeStepAdapter() {
        showAddRecipeAdaper = ShowAddRecipeStepsAdapter() {
            arrayOfStep.removeAt(it)
            showAddRecipeAdaper.addNewList(arrayOfStep)
            showAddRecipeAdaper.notifyDataSetChanged()

        }
        binding.rvShowAddRecipeStep.adapter = showAddRecipeAdaper
        showAddRecipeAdaper.addNewList(arrayOfStep)
    }

    private val cropImage = registerForActivityResult(CropImageContract()) { result ->
        if (result.isSuccessful) {
            // use the returned uri
            val uriContent = result.uriContent
            val uriFilePath = result.getUriFilePath(this,true) // optional usage

            val fi = File(uriFilePath.toString())

            Log.e("filenameee",uriFilePath.toString())




            fi.let {

                if (it.isNotNull()) {
                    lifecycleScope.async {
                        val compressedImageFile = Compressor.compress(baseContext, it)
                        arrayimg.add(it)
                        recipeImageClickAdapter()


//                        setfile(compressedImageFile)
                    }

                }
            }

        } else {
            // an error occurred
            val exception = result.error

        }
    }

    private fun askPermission() {
        val permissionList = ArrayList<String>()
        permissionList.add(android.Manifest.permission.CAMERA)
        PermissionX.init(this)
            .permissions(permissionList)
            .onExplainRequestReason { scope, deniedList ->
                scope.showRequestReasonDialog(
                    deniedList,
                    getString(R.string.permisionmsgfirst),
                    getString(R.string.ok),
                    getString(R.string.cancel)
                )
            }
            .onForwardToSettings { scope, deniedList ->
                scope.showForwardToSettingsDialog(
                    deniedList,
                    getString(R.string.manualpermission),
                    getString(R.string.ok),
                    getString(R.string.cancel)
                )
            }
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    startCrop()
                    Log.e("permisssion granted", "permission granted")
                }

            }
    }

    private fun startCrop() {
        // start picker to get image for cropping and then use the image in cropping activity
        cropImage.launch(
            options {
                setGuidelines(CropImageView.Guidelines.ON)
            }
        )
    }

    //Api Implement
    private fun editProfileApi() {
        val fields = ArrayList<MultipartBody.Part>()
        arrayimg.forEach {
            getMultiPart(Keys.RECIPE_IMGS, it)?.let { fields.add(it) }
        }

        getMultiPart(Keys.RECIPE_NAME, binding.etname.text.toString())?.let { fields.add(it) }
        getMultiPart(Keys.RECIPE_TIME, binding.ettime.text.toString())?.let { fields.add(it) }
        getMultiPart(Keys.RECIPE_VIDEO_LINK, binding.etvideolink.text.toString())?.let {
            fields.add(
                it
            )
        }
        getMultiPart(Keys.RECIPE_INGREDIENTS, arrayOfIngredient)?.let { fields.add(it) }
        getMultiPart(Keys.RECIPE_STEPS, arrayOfStep)?.let { fields.add(it) }
        commonRepository.createRecipe(this, fields) {

        }


    }

}