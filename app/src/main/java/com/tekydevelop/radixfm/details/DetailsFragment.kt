package com.tekydevelop.radixfm.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import com.tekydevelop.domain.model.topalbum.Album
import com.tekydevelop.radixfm.R
import com.tekydevelop.radixfm.base.BaseFragment
import com.tekydevelop.radixfm.databinding.FragmentDetailsBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
    }

    private fun initData() {
        val model: Album? = arguments?.getSerializable("album_item") as Album?
        model?.let {
            binding.albumName.text = it.name
            binding.artistName.text = it.artist.name

            //todo fix load(it.image[3].url)
            Glide.with(requireContext())
                .load(it.image[3].url)
                .error(R.drawable.placeholder)
                .into(binding.albumCover)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val searchMenuItem: MenuItem = menu.findItem(R.id.action_search)
        searchMenuItem.isVisible = false
    }

}