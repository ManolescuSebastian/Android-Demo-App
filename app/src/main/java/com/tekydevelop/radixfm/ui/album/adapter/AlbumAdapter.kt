package com.tekydevelop.radixfm.ui.album.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tekydevelop.domain.model.entity.AlbumItem
import com.tekydevelop.radixfm.R

class AlbumAdapter(private val listener: (AlbumItem) -> Unit, private val longPressListener: (AlbumItem) -> Unit) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    private var context: Context? = null
    private var albumItem: List<AlbumItem> = mutableListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val albumName: TextView = view.findViewById(R.id.album_name)
        val artistName: TextView = view.findViewById(R.id.artist_name)
        val albumImage: ImageView = view.findViewById(R.id.album_image)
        val itemRoot: ConstraintLayout = view.findViewById(R.id.item_root)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_item, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = albumItem[position]

        holder.albumName.text = item.album
        holder.artistName.text = item.artist
        holder.itemRoot.setOnClickListener { listener(item) }
        holder.itemRoot.setOnLongClickListener {
            longPressListener(item)
            true
        }

        if (context != null) {
            Glide.with(context!!)
                .load(item.imageUrl)
                .centerCrop()
                .error(R.drawable.ic_placeholder)
                .into(holder.albumImage)
        }
    }

    override fun getItemCount(): Int {
        return albumItem.size
    }

    fun update(albumItem: List<AlbumItem>) {
        this.albumItem = albumItem
        notifyDataSetChanged()
    }
}
