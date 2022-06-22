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
import com.app.foodrecipe.databinding.FragmentOTPScreenBinding
import kotlinx.android.synthetic.main.fragment_create_password.*


class CreatePasswordFragment : KotlinBaseFragment() {

    lateinit var binding: FragmentCreatePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreatePasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()
    }

    private fun setToolbar() {
        binding.loginbutton.setOnClickListener {
            if (validation()) {
                findNavController().navigate(R.id.loginScreenFragment)
            }
        }
    }

    private fun validation(): Boolean {

        passwordlayout.error = null
        confirmpasswordlayout.error = null
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