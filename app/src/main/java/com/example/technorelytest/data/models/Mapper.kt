package com.example.technorelytest.data.models

class Mapper {

    fun map(artists: List<Artist>?): List<EntityArtist> {

        val list: MutableList<EntityArtist> = ArrayList()
        if (artists != null) {
            for (artist in artists) {
                list.add(
                    EntityArtist(
                        artist.name,
                        artist.listeners,
                        artist.mbid,
                        artist.url,
                        artist.streamable,
                        artist.image[0].link,
                        artist.image[2].link
                    )
                )
            }
        }
        return list
    }
}