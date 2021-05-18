package com.tekydevelop.radixfm.search

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tekydevelop.radixfm.R
import com.tekydevelop.radixfm.base.BaseFragment
import com.tekydevelop.radixfm.databinding.FragmentSearchBinding
import com.tekydevelop.radixfm.search.adapter.SearchAdapter
import com.tekydevelop.radixfm.util.KeyboardUtils
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    private val searchViewModel: SearchViewModel by viewModel()

    private lateinit var searchAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initEvents()
        initObservers()
    }

    private fun initData() {
        searchAdapter = SearchAdapter {

        }

        binding.searchAlbumsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchAdapter
        }
    }

    private fun initEvents() {
        binding.searchAction.setOnClickListener {
            searchViewModel.searchAlbumByName(binding.searchTextInputField.text.toString())
            showLoadingIndicator(true)
            KeyboardUtils.hideKeyboard(binding.searchTextInputField)
        }
    }

    private fun initObservers() {
        searchViewModel.searchAlbums.observe(viewLifecycleOwner) {
            searchAdapter.update(it.searchResultData.albumMatches.album)
            showLoadingIndicator(false)
        }

        searchViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_SHORT).show()
            showLoadingIndicator(false)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val searchMenuItem: MenuItem = menu.findItem(R.id.action_search)
        searchMenuItem.isVisible = false
    }

    private fun showLoadingIndicator(show: Boolean) {
        if (show) {
            binding.loadingIndicator.visibility = View.VISIBLE
        } else {
            binding.loadingIndicator.visibility = View.GONE
        }
    }
}