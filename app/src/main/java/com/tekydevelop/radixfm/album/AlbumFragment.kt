package com.tekydevelop.radixfm.album

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.tekydevelop.radixfm.R
import com.tekydevelop.radixfm.album.adapter.AlbumAdapter
import com.tekydevelop.radixfm.base.BaseFragment
import com.tekydevelop.radixfm.databinding.FragmentAlbumsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AlbumFragment : BaseFragment<FragmentAlbumsBinding>(FragmentAlbumsBinding::inflate) {

    private val albumViewModel: AlbumViewModel by viewModel()

    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_MyAlbum_to_TopAlbums)
        }

        initData()
        initObserver()
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
        albumViewModel.loadAlbumsData()

        albumAdapter = AlbumAdapter {
            Bundle().apply {
                if (it.mbid.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), "Album missing data (no mbid)", Toast.LENGTH_SHORT).show()
                } else {
                    putString("album_mbid", it.mbid)
                    findNavController().navigate(R.id.action_MyAlbums_to_Details, this)
                }
            }
        }

        binding.albumsRecycler.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = albumAdapter
        }
    }

    private fun initObserver() {
        albumViewModel.albumItems.observe(viewLifecycleOwner) {
            albumAdapter.update(it)
            binding.noData.visibility = View.GONE
        }

        albumViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_SHORT).show()
        }
    }
}