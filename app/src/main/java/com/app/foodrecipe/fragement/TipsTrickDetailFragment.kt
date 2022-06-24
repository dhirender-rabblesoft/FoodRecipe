package com.app.foodrecipe.fragement

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.adapter.TipsTicksAdapter
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentTipsTrickDetailBinding
import com.app.foodrecipe.databinding.FragmentTipsTrickFragementBinding
import com.app.foodrecipe.extension.invisible
import com.app.foodrecipe.model.TipsTrickModel
import com.app.foodrecipe.screens.CommonActivity


class TipsTrickDetailFragment(val baseActivity: KotlinBaseActivity) : KotlinBaseFragment() {
    lateinit var binding: FragmentTipsTrickDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTipsTrickDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setClick()
        setToolbar()
        setTipsTrcikAdapter()
    }

    private fun setToolbar(){
        binding.toolbar.menuIcon.setImageResource(R.drawable.back_arrow)
        binding.toolbar.tvtitle.setText("")
        binding.toolbar.filterIcon.invisible()
        binding.toolbar.menuIcon.setOnClickListener {
            baseActivity.onBackPressed()
        }

    }

    private fun setClick() {
//        binding.ivback.setOnClickListener {
//            baseActivity.onBackPressed()
//        }
    }
    private fun setTipsTrcikAdapter() {
      val  listoftips = ArrayList<TipsTrickModel>()
        listoftips.add(
            TipsTrickModel(
                "Reduce Sault In Food",
                "Potato",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
                "4.5",
                5,
                true
            )
        )
        listoftips.add(
            TipsTrickModel(
                "Make Chicken Tasty",
                "Onion",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
                "3.5",
                100,
                false
            )
        )
        listoftips.add(
            TipsTrickModel(
                "Make Food more delicious",
                "Jeera",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
                "2.5",
                2000,
                false
            )
        )
        val tipsTrickAdapter = TipsTicksAdapter() {


        }
        binding.rvPopluarTipsTrick.adapter = tipsTrickAdapter
        tipsTrickAdapter.addNewList(listoftips)

    }



}