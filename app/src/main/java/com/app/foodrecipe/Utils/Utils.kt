package com.app.foodrecipe.Utils

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

object Utils {
    fun setDialogAttributes(dialog: Dialog, height: Int) {
        val window = dialog.window ?: return
        window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, height)
        window.setGravity(Gravity.CENTER)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
    fun hideKeyBoard(c: Context, v: View) {
        val imm = c
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)


    }


    fun shareintent(context: Context, content: String, msg: String = "") {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, msg + "\n" + content)

        }
        val shareIntnet = Intent.createChooser(sendIntent, null)
        context.startActivity(shareIntnet)
    }


}