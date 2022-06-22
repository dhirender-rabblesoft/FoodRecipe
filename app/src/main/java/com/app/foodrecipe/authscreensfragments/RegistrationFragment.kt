package com.app.foodrecipe.authscreensfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.foodrecipe.R
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentCreatePasswordBinding
import com.app.foodrecipe.databinding.FragmentRegistrationBinding
import com.app.foodrecipe.extension.isEmailValid
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : KotlinBaseFragment() {

    lateinit var binding: FragmentRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClick()
    }

    private fun setClick() {
        binding.loginbutton.setOnClickListener {
            if (validation()) {
                findNavController().navigate(R.id.loginScreenFragment)
            }
        }
        binding.llogin.setOnClickListener {

                findNavController().navigate(R.id.loginScreenFragment)
        }

    }

    private fun validation(): Boolean {
        namelayout.error = null
        emaillayout.error = null
        passwordlayout.error = null
        phonelayout.error = null
        confirmpasswordlayout.error = null
        if (etusername.text.toString().trim().isEmpty()) {
            namelayout.error = getString(R.string.enter_your_full_name)
            return false
        }
        if (etemail.text.toString().trim().isEmpty()) {
            emaillayout.error = getString(R.string.v_emailvalidation)
            return false
        }
        if (!isEmailValid(etemail.text.toString().trim())) {
            emaillayout.error = getString(R.string.v_validemail)
            return false
        }
        if (etphone.text.toString().trim().isEmpty()) {
            phonelayout.error = getString(R.string.enter_phone_number)

            // showToast(mContext.getString(R.string.v_password))
            return false
        }
        if (etphone.text.toString().trim().length < 10) {
            phonelayout.error = getString(R.string.phonelength)

            // showToast(mContext.getString(R.string.passwordlength))
            return false
        }
        if (etpassword.text.toString().trim().isEmpty()) {
            passwordlayout.error = getString(R.string.v_validpassword)
            return false
        }
        if (etconfirmpassword.text.toString().trim().isEmpty()) {
            confirmpasswordlayout.error = getString(R.string.v_comfirmpassword)
            return false
        }
        if (!etconfirmpassword.text.toString().trim()
                .equals(etpassword.text.toString().trim())
        ) {
            confirmpasswordlayout.error = getString(R.string.passwordnotmatch)
            //   showToast(mContext.getString(R.string.passwordnotmatch))
            return false
        }


        return true

    }


}