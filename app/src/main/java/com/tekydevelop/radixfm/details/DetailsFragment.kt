package com.tekydevelop.radixfm.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.tekydevelop.radixfm.R
import com.tekydevelop.radixfm.base.BaseFragment
import com.tekydevelop.radixfm.databinding.FragmentDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val detailsViewModel: DetailsViewModel by viewModel()

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
        val mbid: String? = arguments?.getString("album_mbid")
        mbid?.let { detailsViewModel.getAlbumDetails(it) }
    }

    private fun initObserver() {
        detailsViewModel.albumInfoResult.observe(viewLifecycleOwner) {
            it?.let {
                binding.albumName.text = it.album.name
                binding.artistName.text = it.album.artist

                val imageCount = (it.album.image.size - 1)

                Glide.with(requireContext())
                    .load(it.album.image[imageCount].url)
                    .error(R.drawable.placeholder)
                    .into(binding.albumCover)
            }
        }

        detailsViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val searchMenuItem: MenuItem = menu.findItem(R.id.action_search)
        searchMenuItem.isVisible = false
    }

}