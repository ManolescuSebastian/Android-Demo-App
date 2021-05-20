package com.tekydevelop.radixfm.ui.album

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.tekydevelop.radixfm.R
import com.tekydevelop.radixfm.base.BaseFragment
import com.tekydevelop.radixfm.databinding.FragmentAlbumsBinding
import com.tekydevelop.radixfm.ui.album.adapter.AlbumAdapter
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

        albumAdapter = AlbumAdapter({
            Bundle().apply {
                if (it.mbid.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), "Album missing data (no mbid)", Toast.LENGTH_SHORT).show()
                } else {
                    putString("album_mbid", it.mbid)
                    findNavController().navigate(R.id.action_MyAlbums_to_Details, this)
                }
            }
        }, {
            deleteAlbumConfirmationDialog(it.mbid)
        })

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

        albumViewModel.deletedItem.observe(viewLifecycleOwner) {
            albumViewModel.loadAlbumsData()
            Toast.makeText(requireContext(), "Album deleted", Toast.LENGTH_SHORT).show()
        }

        albumViewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Error: $it", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteAlbumConfirmationDialog(mbid: String) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Album")
        alertDialog.setMessage("Do you want to delete the selected album?")
        alertDialog.setPositiveButton("Yes") { _, _ ->
            albumViewModel.deleteAlbumById(mbid)
        }
        alertDialog.setNegativeButton("Cancel") { dialog, id ->
            dialog.cancel()
        }

        val alert = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
/*        val negativeButton = alert.getButton(DialogInterface.BUTTON_NEGATIVE)
        negativeButton.setTextColor(Color.RED)

        val positiveButton = alert.getButton(DialogInterface.BUTTON_POSITIVE)
        positiveButton.setTextColor(Color.GREEN)*/
    }

}