package com.tekydevelop.radixfm.ui.details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.tekydevelop.domain.model.details.Track
import com.tekydevelop.radixfm.R

class TracksAdapter(private val listener: (Track) -> Unit) : RecyclerView.Adapter<TracksAdapter.ViewHolder>() {

    private var context: Context? = null
    private var trackList: List<Track> = mutableListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val trackName: TextView = view.findViewById(R.id.track_name)
        val artistName: TextView = view.findViewById(R.id.artist_name)
        val duration: TextView = view.findViewById(R.id.duration)
        val itemRoot: ConstraintLayout = view.findViewById(R.id.item_root)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.track_item, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = trackList[position]

        holder.trackName.text = item.name
        holder.artistName.text = item.artist.name
        holder.duration.text = item.duration.toString()
        holder.itemRoot.setOnClickListener { listener(item) }
    }

    override fun getItemCount(): Int {
        return trackList.size
    }

    fun update(trackList: List<Track>) {
        this.trackList = trackList
        notifyDataSetChanged()
    }
}