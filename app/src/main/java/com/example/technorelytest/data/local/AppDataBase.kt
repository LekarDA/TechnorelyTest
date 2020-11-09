package com.example.technorelytest.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.technorelytest.data.models.EntityArtist

@Database(entities = [EntityArtist::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun artistsDao(): ArtistsDao

    companion object {
        @Volatile private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDataBase::class.java, "artists")
                .fallbackToDestructiveMigration()
                .build()
    }
}