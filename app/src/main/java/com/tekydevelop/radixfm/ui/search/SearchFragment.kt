package com.tekydevelop.radixfm.ui.search

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
import com.tekydevelop.radixfm.ui.search.adapter.SearchAdapter
import com.tekydevelop.radixfm.util.KeyboardUtils
import com.tekydevelop.radixfm.util.NetworkHelper
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
            Bundle().apply {
                if (it.mbid.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), "Album missing data (no mbid)", Toast.LENGTH_SHORT).show()
                } else {
                    putString("album_mbid", it.mbid)
                    findNavController().navigate(R.id.action_Top_to_Details, this)
                }
            }
        }

        binding.searchAlbumsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchAdapter
        }
    }

    private fun initEvents() {
        binding.searchAction.setOnClickListener {
            if(!NetworkHelper.isNetworkAvailable(requireContext())){
                Toast.makeText(requireContext(), "No internet connection", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            searchViewModel.searchAlbumByName(binding.searchTextInputField.text.toString())
            showLoadingIndicator(true)
            binding.noDataFound.visibility = View.GONE
            KeyboardUtils.hideKeyboard(binding.searchTextInputField)
        }
    }

    private fun initObservers() {
        searchViewModel.searchAlbums.observe(viewLifecycleOwner) {
            searchAdapter.update(it.searchResultData.albumMatches.album)
            showLoadingIndicator(false)

            if (it.searchResultData.albumMatches.album.isEmpty()) {
                binding.noDataFound.visibility = View.VISIBLE
            } else {
                binding.noDataFound.visibility = View.GONE
            }
        }

        searchViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_SHORT).show()
            showLoadingIndicator(false)
            binding.noDataFound.visibility = View.GONE
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