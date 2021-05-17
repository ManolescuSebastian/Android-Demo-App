package com.tekydevelop.radixfm.search

import android.os.Bundle
import android.view.View
import com.tekydevelop.radixfm.base.BaseFragment
import com.tekydevelop.radixfm.databinding.FragmentSearchBinding
import com.tekydevelop.radixfm.databinding.FragmentTopAlbumsBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding ::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initEvents()
    }

    private fun initData() {

    }

    private fun initEvents() {

    }
}