package com.app.foodrecipe.navigator

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.app.foodrecipe.base.KotlinBaseFragment
import kotlin.reflect.KClass

class Navigator(private val activity: AppCompatActivity, private val container: Int) {

    private val fragmentReplacer: FragmentBehaviour by lazy {
        FragmentReplace(container)
    }

    fun openA(kClass: KClass<out AppCompatActivity>, bundle: Bundle? = Bundle()) {
        val intent = Intent(activity, kClass.java)
        intent.putExtras(bundle ?: Bundle())
        activity.startActivity(intent)
        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
        } else {
            activity.startActivity(intent)
        }
*/
    }

    private fun makeFragmentAndShowOnScreen(
        fragment: Fragment,

        manager: FragmentManager,
        behaviour: FragmentBehaviour,
        tag: String?, transitionView: View?, addToBackstack: Boolean
    ): Fragment? {
        var fragment1 = fragment
        val transaction = manager.beginTransaction()
        setTitle(fragment1, transaction)
        behaviour.execute(transaction, fragment1!!, tag)

        if (transitionView != null) {
            transaction.addSharedElement(
                transitionView,
                ViewCompat.getTransitionName(transitionView) ?: ""
            )
        }
        if (addToBackstack)
            transaction.addToBackStack(tag)
        transaction.commit()
        return fragment1
    }

    private fun setTitle(fragment: Fragment?, transaction: FragmentTransaction) {
        if (fragment is KotlinBaseFragment) {

            if (fragment.setBreadCrumbsImage() != null) {
                transaction.setBreadCrumbTitle("" + fragment.setBreadCrumbsImage())
            }
            transaction.setBreadCrumbShortTitle(fragment.setBreadCrumbsTitle())

        }
    }

    fun replaceFragment(
        clazz: Fragment,
        bundle: Bundle?,
        transitionView: View?,
        userTag: String = "",
        addToBackstack: Boolean
    ) {
        executetransition(
            clazz,
            bundle,
            transitionView,
            fragmentReplacer,
            activity.supportFragmentManager,
            userTag,
            addToBackstack
        )
    }

    fun executetransition(
        clazz: Fragment,
        bundle: Bundle?,
        transitionView: View?,
        behaviour: FragmentBehaviour,
        manager: FragmentManager,
        userTag: String = "",
        addToBackstack: Boolean
    ) {


        val tag = if (userTag.isEmpty()) clazz.javaClass.simpleName else userTag
        var fragment = manager.findFragmentByTag(tag)

        if (fragment == null) {
            fragment = makeFragmentAndShowOnScreen(
                clazz,
                manager,
                behaviour,
                tag,
                transitionView,
                addToBackstack
            )
        } else {
            manager.popBackStackImmediate(tag, 0)
        }

        fragment?.arguments = bundle

    }


}