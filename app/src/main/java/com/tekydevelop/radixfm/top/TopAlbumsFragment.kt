package com.tekydevelop.radixfm.top

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tekydevelop.radixfm.R
import com.tekydevelop.radixfm.base.BaseFragment
import com.tekydevelop.radixfm.databinding.FragmentTopAlbumsBinding
import com.tekydevelop.radixfm.top.adapter.TopAlbumAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopAlbumsFragment : BaseFragment<FragmentTopAlbumsBinding>(FragmentTopAlbumsBinding::inflate) {

    private val topAlbumsViewModel: TopAlbumsViewModel by viewModel()
    private lateinit var topAlbumAdapter: TopAlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initObserver()
    }

    private fun initData() {
        showLoadingIndicator(true)

        topAlbumsViewModel.getTopAlbumData()
        topAlbumAdapter = TopAlbumAdapter {
            if (it.image.isNotEmpty()) {
                val imageCount = (it.image.size - 1)
                topAlbumsViewModel.insertSelectedAlbum(it.mbid, it.name, it.artist.name, it.image[imageCount].url)
            }

            Bundle().apply {
                if (it.mbid.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), "Album missing data (no mbid)", Toast.LENGTH_SHORT).show()
                } else {
                    putString("album_mbid", it.mbid)
                    findNavController().navigate(R.id.action_Top_to_Details, this)
                }
            }
        }

        binding.albumsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = topAlbumAdapter
        }
    }

    private fun initObserver() {
        topAlbumsViewModel.topAlbums.observe(viewLifecycleOwner) {
            topAlbumAdapter.update(it.topAlbums.albums)
            showLoadingIndicator(false)
        }

        topAlbumsViewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), "Error: $error", Toast.LENGTH_LONG).show()
            showLoadingIndicator(false)
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

    private fun showLoadingIndicator(show: Boolean) {
        if (show) {
            binding.loadingIndicator.visibility = View.VISIBLE
        } else {
            binding.loadingIndicator.visibility = View.GONE
        }
    }
}