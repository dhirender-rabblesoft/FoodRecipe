package com.app.foodrecipe.Utils

import android.content.Context

class SharedPreferenceManager(private val context: Context) {
    private fun getSharedPreference() =
        context.getSharedPreferences(SHARE_PRE_NAME, Context.MODE_PRIVATE)

    private fun getEditor() = getSharedPreference().edit()
    fun saveString(key: String, value: String) = getEditor().putString(key, value).apply()
    fun getString(key: String, default: String? = null): String? =
        getSharedPreference().getString(key, default)

    fun saveNumber(key: String, value: Long) = getEditor().putLong(key, value).commit()
    fun getNumber(key: String, default: Long = 0): Long =
        getSharedPreference().getLong(key, default)

    fun removeValue(key: String) = getEditor().remove(key)

    companion object {
        private const val SHARE_PRE_NAME = "food_recipe"
    }
}