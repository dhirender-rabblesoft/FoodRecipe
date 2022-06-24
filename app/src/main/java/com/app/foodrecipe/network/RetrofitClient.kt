package com.app.foodrecipe.network

import android.content.Context
import com.app.foodrecipe.BuildConfig
import com.app.foodrecipe.Utils.Keys
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Time
import java.util.concurrent.TimeUnit

class RetrofitClient {

    val client: Retrofit?
        get() {
            var token = ""
            if (retrofit == null) retrofit = provideRetrofit(APP_BASE_URL, token)
            return retrofit

        }

    private fun provideRetrofit(baseUrl: String, tokens: String): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(interceptor)
        }
        return Retrofit.Builder()
            .baseUrl(Keys.BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()


    }

    companion object {
        var APP_BASE_URL = ""
        private const val CACHE_CONTROL = "Cache_Control"
        var retrofit: Retrofit? = null
        private var mContext: Context? = null
        private var retrofitClient: RetrofitClient? = null
        fun with(context: Context?): RetrofitClient? {
            if (retrofitClient == null) retrofitClient = RetrofitClient()
            mContext = context
            return retrofitClient
        }
    }

}