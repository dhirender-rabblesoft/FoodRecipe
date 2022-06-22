package com.app.foodrecipe.base

import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.app.foodrecipe.listner.KotlinBaseListener
import com.app.foodrecipe.navigator.FragmentBehaviour
import com.app.foodrecipe.navigator.Navigator
import kotlin.reflect.KClass

open class KotlinBaseActivity(@IdRes private val container: Int = 0) : AppCompatActivity(),
    KotlinBaseListener {


    private val navigator: Navigator by lazy { Navigator(this, container) }


    fun navigateToFragment(
        clazz: Fragment,
        bundle: Bundle? = null,
        transitionView: View? = null,
        userTag: String = "",
        addToBackstack: Boolean
    ) {
        navigator.replaceFragment(clazz, bundle, transitionView, userTag, addToBackstack)
    }


    override fun openA(kClass: KClass<out AppCompatActivity>, extras: Bundle?) {
        navigator.openA(kClass, extras)
    }

    override fun navigateToFragment(java: Fragment, extras: Bundle?, addToBackstack: Boolean) {
        navigateToFragment(java, extras, transitionView = null, addToBackstack = addToBackstack)
    }

    override fun navigateToFragment(
        fragment: Fragment,
        extras: Bundle?,
        userTag: String,
        addToBackstack: Boolean
    ) {
    }

    override fun addFragment(
        fragment: Fragment,
        extras: Bundle?,
        tag: String,
        addToBackstack: Boolean
    ) {
    }

    override fun addChildFragment(
        childFragmentManager: FragmentManager,
        container: Int,
        kClass: Fragment,
        extras: Bundle?,
        addToBackstack: Boolean
    ) {
    }

    override fun replaceChildFragment(
        childFragmentManager: FragmentManager,
        container: Int,
        kClass: Fragment,
        extras: Bundle?,
        addToBackstack: Boolean
    ) {
    }

    override fun openAForResult(kClass: KClass<out AppCompatActivity>, bundle: Bundle, code: Int) {
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun showAlert(message: String) {
    }

    override fun getFragment(kClass: Fragment): Fragment? {
        val fragment = supportFragmentManager.findFragmentByTag(kClass.javaClass.simpleName)
        return if (fragment != null) fragment as Fragment else null
    }


}