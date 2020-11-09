package com.example.technorelytest.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.technorelytest.R
import com.example.technorelytest.Utils.EXTRA
import com.example.technorelytest.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ItemClickListener {

    private val viewModel: ListArtistsViewModel by viewModels()
    private lateinit var artistsAdapter : ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createList()

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                itemSelected: View?, selectedItemPosition: Int, selectedId: Long
            ) {
                val listOfCountries = resources.getStringArray(R.array.countries)
                viewModel.fetchPopularArtistsByCountry(listOfCountries[selectedItemPosition])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        viewModel.fetchPopularArtistsByCountry(spinner.selectedItem.toString())
        viewModel.popularArtistsLiveData.observe(this, Observer {
            artistsAdapter.setData(it)
        })
    }

    private fun createList() {
        artistsAdapter = ArtistAdapter()
        artistsAdapter.setItemClickListener(this)
        val listlayoutManager = LinearLayoutManager(this)
        rvListOfArtists.apply {
            layoutManager = listlayoutManager
            setHasFixedSize(true)
            adapter = artistsAdapter
        }
    }

    override fun onDestroy() {
        viewModel.cancelAllRequests()
        super.onDestroy()
    }


    override fun onItemClick(id: String) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(EXTRA, id)
        }
        startActivity(intent)
    }
}