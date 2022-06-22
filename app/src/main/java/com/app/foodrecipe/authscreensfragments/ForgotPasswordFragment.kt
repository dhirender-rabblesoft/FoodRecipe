package com.app.foodrecipe.authscreensfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.foodrecipe.R
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentForgotPasswordBinding
import com.app.foodrecipe.extension.isEmailValid
import kotlinx.android.synthetic.main.fragment_forgot_password.*

class ForgotPasswordFragment : KotlinBaseFragment() {
    lateinit var binding: FragmentForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClick()
    }

    private fun setClick() {
        binding.loginbutton.setOnClickListener {
            if (validation()) {
                findNavController().navigate(R.id.OTPScreenFragment)
            }

        }
    }

    private fun validation(): Boolean {
        emaillayout.error = null

        if (etemail.text.toString().trim().isEmpty()) {
            emaillayout.error = getString(R.string.v_emailvalidation)
            return false
        }
        if (!isEmailValid(etemail.text.toString().trim())) {
            emaillayout.error = getString(R.string.v_validemail)
            return false
        }
        return true
    }


}