package com.app.foodrecipe.authscreensfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.foodrecipe.R
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentLoginScreenBinding
import com.app.foodrecipe.extension.isEmailValid
import com.app.foodrecipe.screens.MainActivity
import kotlinx.android.synthetic.main.fragment_login_screen.*


class LoginScreenFragment : KotlinBaseFragment() {

    lateinit var binding: FragmentLoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClick()
    }


    private fun validation(): Boolean {
        passwordlayout.error = null
        emaillayout.error = null

        if (etemail.text.toString().trim().isEmpty()) {
            emaillayout.error = getString(R.string.v_emailvalidation)
            return false
        }
        if (!isEmailValid(etemail.text.toString().trim())) {
            emaillayout.error = getString(R.string.v_validemail)
            return false
        }

        if (etpassword.text.toString().trim().isEmpty()) {
            passwordlayout.error = getString(R.string.v_validpassword)
            return false
        }
        return true

    }

    private fun setClick() {
        binding.loginbutton.setOnClickListener {
            baselistener.openA(MainActivity::class)
//            if (validation()) {
//                baselistener.openA(MainActivity::class)
//                requireActivity().finishAffinity()
//            }

        }
        binding.tvforgotpasssword.setOnClickListener {
            findNavController().navigate(R.id.forgotPasswordFragment)
        }
        binding.llsignup.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }
    }


}