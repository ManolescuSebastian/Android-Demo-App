package com.tekydevelop.radixfm.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tekydevelop.radixfm.R
import com.tekydevelop.radixfm.album.AlbumViewModel
import com.tekydevelop.radixfm.album.adapter.AlbumAdapter
import com.tekydevelop.radixfm.databinding.FragmentAblumDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumDetailsFragment : Fragment() {

    private var _binding: FragmentAblumDetailsBinding? = null
    private val binding get() = _binding!!

    private val albumDetailsViewModel: AlbumDetailsViewModel by viewModel()

    private lateinit var albumAdapter: AlbumAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAblumDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initObserver()
    }

    private fun initData() {
        albumDetailsViewModel.getTopAlbumData()

        albumAdapter = AlbumAdapter {
            Toast.makeText(requireContext(), "Item selected", Toast.LENGTH_SHORT).show()
        }

        binding.albumsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = albumAdapter
        }
    }

    private fun initObserver() {
        albumDetailsViewModel.topAlbums.observe(viewLifecycleOwner) {
            albumAdapter.update(it.topAlbums.albums)
        }

        albumDetailsViewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), "Error: $error", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}