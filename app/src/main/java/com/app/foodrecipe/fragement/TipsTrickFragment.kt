package com.app.foodrecipe.fragement

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.Utils.Utils
import com.app.foodrecipe.adapter.TipsTicksAdapter
import com.app.foodrecipe.base.KotlinBaseFragment
import com.app.foodrecipe.databinding.FragmentTipsTrickFragementBinding
import com.app.foodrecipe.extension.gone
import com.app.foodrecipe.extension.invisible
import com.app.foodrecipe.model.TipsTrickModel
import com.app.foodrecipe.screens.AddTipsTrickActivity
import com.app.foodrecipe.screens.CommonActivity
import kotlinx.android.synthetic.main.common_toolbar.view.*

class TipsTrickFragment : KotlinBaseFragment() {
    lateinit var binding: FragmentTipsTrickFragementBinding
    var keyword = ""
    var listoftips = ArrayList<TipsTrickModel>()
    lateinit var tipsTrickAdapter: TipsTicksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTipsTrickFragementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClick()
        setTipsTrcikAdapter()
        setToolbar()
        searchListner()
    }

    private fun setToolbar() {
        val toolbar = requireActivity().findViewById<View>(R.id.toolbar)
        toolbar.tvtitle.setText("Tips Trick")
        toolbar.filter_icon.invisible()
        toolbar.filter_icon2.gone()

    }


    private fun searchListner() {


        binding.searchbar.edsearchtext.addTextChangedListener {
            var keyword = it.toString()
            var templist = ArrayList<TipsTrickModel>()
            listoftips.forEach {
                if (it.title.lowercase().contains(keyword.lowercase())) {
                    templist.clear()
                    templist.add(it)
                    Log.e("ededededeeded", templist.toString())
                    if (keyword.lowercase().isEmpty()) {
                        tipsTrickAdapter.addNewList(listoftips)
                    } else {
                        tipsTrickAdapter.addNewList(templist)
                    }
                    tipsTrickAdapter.notifyDataSetChanged()
                }
            }
        }

    }


    private fun filterdata(keyword: String) {
        listoftips.forEach {
            if (keyword.equals(it.title)) {
                listoftips.clear()
                listoftips.add(it)
                tipsTrickAdapter.addNewList(listoftips)
                tipsTrickAdapter.notifyDataSetChanged()

            }
        }

    }

    private fun setClick() {
        binding.addTipsTrickbutton.setOnClickListener {
//            baselistener.openA(AddTipsTrickActivity::class)
        }
    }

    private fun setTipsTrcikAdapter() {
        listoftips = ArrayList<TipsTrickModel>()
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
        listoftips.add(
            TipsTrickModel(
                "Kathai Chikecn",
                "Black Paper",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
                "1.5",
                50000,
                false
            )
        )
        listoftips.add(
            TipsTrickModel(
                "Butter Chicken make more tasty",
                "Potato",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
                "5.0",
                50,
                true
            )
        )
        listoftips.add(
            TipsTrickModel(
                "Make roti more soft",
                "Onion",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
                "5.0",
                256,
                true
            )
        )
        listoftips.add(
            TipsTrickModel(
                "make food in 15 min",
                "Water",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
                "5.0",
                650000000,
                true
            )
        )
        listoftips.add(
            TipsTrickModel(
                "boil egg tips",
                "Seeds",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
                "5.0",
                850,
                true
            )
        )
        listoftips.add(
            TipsTrickModel(
                "boil sea food tips",
                "Gulab jal",
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.",
                "5.0",
                920,
                true
            )
        )
        tipsTrickAdapter = TipsTicksAdapter() {
            val bundle = Bundle()
            bundle.putString(Keys.FRAGMENT_FROM, Keys.FRAGMENT_TIPS_TRICK_DETAIL.toString())
            baselistener.openA(CommonActivity::class, bundle)

        }
        binding.rvTipTrick.adapter = tipsTrickAdapter
        tipsTrickAdapter.addNewList(listoftips)

    }


}