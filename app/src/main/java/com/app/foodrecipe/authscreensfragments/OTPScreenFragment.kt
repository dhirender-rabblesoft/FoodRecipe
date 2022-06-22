package com.app.foodrecipe.authscreensfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.foodrecipe.R
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentOTPScreenBinding
import kotlinx.android.synthetic.main.fragment_o_t_p_screen.*


class OTPScreenFragment : KotlinBaseFragment() {
    lateinit var binding: FragmentOTPScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOTPScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClick()
    }

    private fun setClick() {
        binding.loginbutton.setOnClickListener {
            if (validation()) {
                findNavController().navigate(R.id.createPasswordFragment)
            }
        }
    }


    private fun validation(): Boolean {
        codelayout.error = null
        if (etcode.text.toString().trim().isEmpty()) {
            codelayout.error = getString(R.string.enter_code)
            return false
        }
        if (etcode.text.toString().trim().length < 4) {
            codelayout.error = getString(R.string.valid_code)
            return false
        }

        return true

    }

}