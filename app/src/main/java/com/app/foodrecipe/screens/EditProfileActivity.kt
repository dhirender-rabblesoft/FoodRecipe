package com.app.foodrecipe.screens

import android.app.Application
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.Utils.SharedPreferenceManager
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.databinding.ActivityEditProfileBinding
import com.app.foodrecipe.extension.getMultiPart
import com.app.foodrecipe.extension.invisible
import com.app.foodrecipe.extension.isNotNull
import com.app.foodrecipe.repository.CommonRepository
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageView
import com.canhub.cropper.options
import com.google.gson.Gson
import com.permissionx.guolindev.PermissionX
import id.zelory.compressor.Compressor
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.coroutines.async
import okhttp3.MultipartBody
import java.io.File

class EditProfileActivity : KotlinBaseActivity() {
    lateinit var binding: ActivityEditProfileBinding
    var file: File? = null
    val commonRepository = CommonRepository(Application())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLevelDropDown()
        setToolbar()
        setClick()

    }

    private fun setToolbar() {
        binding.toolbar.menuIcon.setImageResource(R.drawable.back_arrow)
        binding.toolbar.tvtitle.setText("Edit Profile")
        binding.toolbar.filterIcon.invisible()
        binding.toolbar.menuIcon.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setLevelDropDown() {
        val levels = resources.getStringArray(R.array.chief_level)
        val levelAdapter = ArrayAdapter(this, R.layout.dropdown_item, levels)
        binding.etlevel.setAdapter(levelAdapter)
    }

    private fun setClick() {
        binding.ivcamera.setOnClickListener {
            askPermission()
        }
        binding.loginbutton.setOnClickListener {
            if (validation()) {
                Log.e("324234234", "dsfsdfsdfsdfsfd")
            }
        }
    }


    //for editprofile api
    private fun editProfile() {
        val fields =  ArrayList<MultipartBody.Part>()
        getMultiPart(Keys.user_name, binding.etname.text.toString())?.let { fields.add(it) }
        getMultiPart(
            Keys.user_phone_number,
            binding.etphone.text.toString()
        )?.let { fields.add(it) }
        getMultiPart(Keys.user_level, binding.etlevel.text.toString())?.let { fields.add(it) }
        if (file.isNotNull()) {
            getMultiPart(Keys.file, file!!)?.let { fields.add(it) }
        }
        commonRepository.updateProfile(this, fields) {
            val gson = Gson()
            val json = gson.toJson(it)
            SharedPreferenceManager(this).saveString(Keys.USERDATA, json)
            onBackPressed()

        }

    }


    private val cropImage = registerForActivityResult(CropImageContract()) { result ->
        if (result.isSuccessful) {
            // use the returned uri
            val uriContent = result.uriContent
            val uriFilePath = result.getUriFilePath(this) // optional usage
            val fi = File(uriFilePath.toString())

            fi.let {
                if (it.isNotNull()) {
//                    viewmodel.setfile(it)
                    // Glide.with(this).load(it).into(binding.ivprofile)
                    lifecycleScope.async {
                        val compressedImageFile = Compressor.compress(baseContext, it)
                        setfile(compressedImageFile)
                    }

                }
            }

        } else {
            // an error occurred
            val exception = result.error

        }
    }

    private fun startCrop() {
        // start picker to get image for cropping and then use the image in cropping activity
        cropImage.launch(
            options {
                setGuidelines(CropImageView.Guidelines.ON)
                setOutputCompressFormat(Bitmap.CompressFormat.WEBP)
            }
        )
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


    fun setfile(file: File) {
        this.file = file
        Glide.with(this).load(file).diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true).into(binding.foodimage)

    }

    private fun validation(): Boolean {
        binding.namelayout.error = null
        binding.phonelayout.error = null
        binding.levellayout.error = null
        if (etname.text.toString().isEmpty()) {
            binding.namelayout.error = getString(R.string.v_validname)
            return false
        }
        if (etphone.text.toString().isEmpty()) {
            binding.phonelayout.error = getString(R.string.v_validphone)
            return false
        }
        if (etlevel.text.toString().equals(getString(R.string.choose))) {
            binding.levellayout.error = getString(R.string.valid_level)
            return false
        }
        return true
    }


}