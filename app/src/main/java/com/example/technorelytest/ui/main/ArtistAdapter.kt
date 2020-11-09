package com.example.technorelytest.ui.main


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.technorelytest.R
import com.example.technorelytest.data.models.Artist

class ArtistAdapter : RecyclerView.Adapter<ArtistViewHolder>() {
    private val listOfArtists: ArrayList<Artist> = ArrayList()
    private var listener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ArtistViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.initView(listOfArtists[position])
        holder.itemView.setOnClickListener {
            listener?.onItemClick(listOfArtists[holder.adapterPosition].mbid)
        }
    }

    override fun getItemCount() = listOfArtists.size

    fun setData(artists: List<Artist>){
        listOfArtists.clear()
        listOfArtists.addAll(artists)
        notifyDataSetChanged()
    }

    fun setItemClickListener(clicklistener: ItemClickListener?) {
        this.listener = clicklistener
    }
}