package com.app.foodrecipe.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.app.foodrecipe.navigator.FragmentBehaviour

class FragmentReplace(val container: Int) : FragmentBehaviour() {
    override fun execute(transaction: FragmentTransaction, fragment: Fragment, tag: String?) {
        transaction.replace(container, fragment, tag)
    }

}