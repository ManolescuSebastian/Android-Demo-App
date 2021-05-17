package com.tekydevelop.radixfm.album

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tekydevelop.radixfm.R
import com.tekydevelop.radixfm.album.adapter.AlbumAdapter
import com.tekydevelop.radixfm.databinding.FragmentAlbumsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AlbumFragment : Fragment() {

    private var _binding: FragmentAlbumsBinding? = null
    private val binding get() = _binding!!

    private val albumViewModel: AlbumViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_Album_to_Details)
        }

    }

    private fun initData() {

    }

    private fun initObserver() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}