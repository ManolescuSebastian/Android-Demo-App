package com.tekydevelop.radixfm.album

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.fragment.findNavController
import com.tekydevelop.radixfm.R
import com.tekydevelop.radixfm.base.BaseFragment
import com.tekydevelop.radixfm.databinding.FragmentAlbumsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AlbumFragment : BaseFragment<FragmentAlbumsBinding>(FragmentAlbumsBinding::inflate) {

    private val albumViewModel: AlbumViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_Album_to_Details)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val searchMenuItem: MenuItem = menu.findItem(R.id.action_search)
        searchMenuItem.setOnMenuItemClickListener {
            findNavController().navigate(R.id.action_Any_to_Search)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                findNavController().navigate(R.id.action_Any_to_Search)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initData() {

    }

    private fun initObserver() {

    }
}