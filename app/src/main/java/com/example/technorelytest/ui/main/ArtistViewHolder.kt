package com.example.technorelytest.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.technorelytest.R
import com.example.technorelytest.data.models.Artist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class ArtistViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun initView(artist: Artist) {
        Picasso.get().load(artist.image[1].link)
            .placeholder(R.drawable.no_photo).into(itemView.ivArtistPhoto)
        itemView.tvArtistName?.text = artist.name
    }
}