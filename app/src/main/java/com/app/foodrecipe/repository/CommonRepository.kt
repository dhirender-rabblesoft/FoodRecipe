package com.app.foodrecipe.repository

import android.app.Application
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.Utils.NetworkCheck
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.network.APIInterface
import com.app.foodrecipe.network.RetrofitClient
import okhttp3.Callback
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class CommonRepository(private val baseActivity: Application) {
    var retrofitClient: APIInterface? = null

    fun updateProfile(
        baseActivity: KotlinBaseActivity,
        fields: ArrayList<MultipartBody.Part>,
        itemClick: (ResponseBody) -> Unit
    ) {
        if (!NetworkCheck(baseActivity).isNetworkAvailable()) {
            baseActivity.nointernershowToast()
        } else {
            baseActivity.startProgressDialog()
            retrofitClient =
                RetrofitClient.with(this.baseActivity)?.client?.create(APIInterface::class.java)

            retrofitClient?.updateUser(
                Keys.BASE_URL + "user_update_endpoint", "token", fields
            )!!.enqueue(object : retrofit2.Callback<ResponseBody?> {
                override fun onResponse(
                    call: Call<ResponseBody?>,
                    response: Response<ResponseBody?>
                ) {
                    when (response.code()) {
                        Keys.RESPONSE_SUCESS -> {
                            response.body()?.let { itemClick(it) }
                        }
                        Keys.ERRORCODE -> {
                            baseActivity.parseError(response)
                        }
                        Keys.UNAUTHoRISE -> {
                            // faqmutableLiveData.setValue(response.body())
                        }
                        in 500..512 -> {
                            baseActivity.customSnackBar(
                                baseActivity.getString(R.string.somthingwentwrong),
                                true
                            )
                        }
                    }

                }

                override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {

                }

            })

        }

    }

    fun createRecipe(
        baseActivity: KotlinBaseActivity,
        fields: ArrayList<MultipartBody.Part>,
        itemClick: (ResponseBody) -> Unit
    ) {
        if (!NetworkCheck(baseActivity).isNetworkAvailable()) {
            baseActivity.nointernershowToast()
        } else {
            baseActivity.startProgressDialog()
            retrofitClient =
                RetrofitClient.with(this.baseActivity)?.client?.create(APIInterface::class.java)

            retrofitClient?.createRecipe(
                Keys.BASE_URL + "user_update_endpoint", "token", fields
            )!!.enqueue(object : retrofit2.Callback<ResponseBody?> {
                override fun onResponse(
                    call: Call<ResponseBody?>,
                    response: Response<ResponseBody?>
                ) {
                    when (response.code()) {
                        Keys.RESPONSE_SUCESS -> {
                            response.body()?.let { itemClick(it) }
                        }
                        Keys.ERRORCODE -> {
                            baseActivity.parseError(response)
                        }
                        Keys.UNAUTHoRISE -> {
                            // faqmutableLiveData.setValue(response.body())
                        }
                        in 500..512 -> {
                            baseActivity.customSnackBar(
                                baseActivity.getString(R.string.somthingwentwrong),
                                true
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {

                }

            })

        }

    }

    fun contactus(){

    }

 }