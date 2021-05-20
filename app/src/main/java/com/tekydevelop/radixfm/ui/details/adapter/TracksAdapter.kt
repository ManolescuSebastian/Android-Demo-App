package com.tekydevelop.radixfm.ui.details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tekydevelop.domain.model.details.Track
import com.tekydevelop.radixfm.R
import com.tekydevelop.radixfm.util.Helper

class TracksAdapter : RecyclerView.Adapter<TracksAdapter.ViewHolder>() {

    private var context: Context? = null
    private var trackList: List<Track> = mutableListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val trackName: TextView = view.findViewById(R.id.track_name)
        val artistName: TextView = view.findViewById(R.id.artist_name)
        val duration: TextView = view.findViewById(R.id.duration)
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
        holder.artistName.text = item.artist?.name
        holder.duration.text = item.duration?.let { Helper.formatDuration(it) }
    }

    override fun getItemCount(): Int {
        return trackList.size
    }

    fun update(trackList: List<Track>) {
        this.trackList = trackList
        notifyDataSetChanged()
    }
}