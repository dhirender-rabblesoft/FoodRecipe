package com.app.foodrecipe.base

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.app.foodrecipe.R
import com.app.foodrecipe.extension.getDecorView
import com.app.foodrecipe.listner.KotlinBaseListener
import com.app.foodrecipe.navigator.Navigator
import com.google.android.material.snackbar.Snackbar
import org.json.JSONObject
import retrofit2.Response
import kotlin.reflect.KClass

open class KotlinBaseActivity(@IdRes private val container: Int = 0) : AppCompatActivity(),
    KotlinBaseListener {
    private var progressDialog: Dialog? = null


    private val navigator: Navigator by lazy { Navigator(this, container) }


    fun nointernershowToast() {
        customSnackBar(getString(R.string.nointernet), true)
//        val myToast = Toast.makeText(this,getString(R.string.nointernet), Toast.LENGTH_SHORT)
//        myToast.setGravity(Gravity.CENTER,0,0)
//        myToast.show()

    }

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

    open fun customSnackBar(message: String?, isError: Boolean) {
        // create an instance of the snackbar
        // create an instance of the snackbar
        val snackbar = Snackbar.make(this.getDecorView().rootView, "", Snackbar.LENGTH_LONG)

        // inflate the custom_snackbar_view created previously

        // inflate the custom_snackbar_view created previously
        val customSnackView: View = layoutInflater.inflate(R.layout.custom_snakbar, null)
        val view = snackbar.view
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP
        view.layoutParams = params
        // set the background of the default snackbar as transparent

        // set the background of the default snackbar as transparent
        snackbar.view.setBackgroundColor(Color.TRANSPARENT)

        // now change the layout of the snackbar

        // now change the layout of the snackbar
        val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

        // set padding of the all corners as 0

        // set padding of the all corners as 0
        snackbarLayout.setPadding(0, 0, 0, 0)

        // register the button from the custom_snackbar_view layout file

        // register the button from the custom_snackbar_view layout file
        val bGotoWebsite: AppCompatImageView = customSnackView.findViewById(R.id.ivcancel)
        val rlmain: RelativeLayout = customSnackView.findViewById(R.id.rlmain)
        val textView1: TextView = customSnackView.findViewById(R.id.textView1)
        textView1.text = message
        if (!isError) {
            rlmain.setBackgroundColor(Color.GREEN)
        }
        // now handle the same button with onClickListener

        // now handle the same button with onClickListener
        bGotoWebsite.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                snackbar.dismiss()
            }
        })

        // add the custom snack bar layout to snackbar layout

        // add the custom snack bar layout to snackbar layout
        snackbarLayout.addView(customSnackView, 0)

        snackbar.show()
    }
    open fun parseError(response: Response<*>)
    {

        val jsonObj = JSONObject(response.errorBody()?.string().toString())
        customSnackBar(jsonObj.getString("message"),true)
        //showtoast(jsonObj.getString("message"))

    }

    fun startProgressDialog() {
        if (progressDialog != null && !progressDialog!!.isShowing) {
            try {
                //   gif1?.gifResource = R.drawable.loader
                progressDialog!!.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }


}