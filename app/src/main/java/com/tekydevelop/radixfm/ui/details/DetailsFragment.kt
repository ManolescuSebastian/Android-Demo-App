package com.tekydevelop.radixfm.ui.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.tekydevelop.radixfm.R
import com.tekydevelop.radixfm.base.BaseFragment
import com.tekydevelop.radixfm.databinding.FragmentDetailsBinding
import com.tekydevelop.radixfm.ui.details.adapter.TracksAdapter
import com.tekydevelop.radixfm.util.NetworkHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val detailsViewModel: DetailsViewModel by viewModel()

    private lateinit var tracksAdapter: TracksAdapter

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
        mbid?.let { detailsViewModel.getAlbumDetails(it, NetworkHelper.isNetworkAvailable(requireContext())) }

        tracksAdapter = TracksAdapter()

        binding.tracksRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = tracksAdapter
        }
    }

    private fun initObserver() {
        detailsViewModel.albumInfoResult.observe(viewLifecycleOwner) {
            it?.let {
                it.tracks?.track?.let { track -> tracksAdapter.update(track) }

                binding.albumName.text = it.name
                binding.artistName.text = it.artist

                if (it.image?.isNotEmpty() == true) {
                    val imageCount = (it.image?.size?.minus(1))
                    Glide.with(requireContext())
                        .load(it.image!![imageCount!!].url)
                        .centerCrop()
                        .error(R.drawable.ic_placeholder)
                        .into(binding.albumCover)
                }

                if (it.imageBitmap != null) {
                    Glide.with(requireContext())
                        .load(it.imageBitmap)
                        .centerCrop()
                        .error(R.drawable.ic_placeholder)
                        .into(binding.albumCover)
                }
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