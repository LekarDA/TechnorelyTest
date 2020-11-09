package com.example.technorelytest.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.technorelytest.R
import com.example.technorelytest.Utils.EXTRA
import com.example.technorelytest.data.models.EntityArtist
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_view.tvArtistName


@AndroidEntryPoint
class DetailActivity: AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.getArtistById(intent.getStringExtra(EXTRA))

        viewModel.artistLiveData.observe(this, Observer {
            initView(it)
        })
    }

    private fun initView(it: EntityArtist?) {
        Picasso.get().load(it?.imageLarge).placeholder(R.drawable.no_photo).into(ivPhoto)
        tvArtistName.text = it?.name
        tvListenersCount.text = it?.listeners
        tvLink.text = it?.url
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onDestroy() {
        viewModel.cancelAllRequests()
        super.onDestroy()
    }
}