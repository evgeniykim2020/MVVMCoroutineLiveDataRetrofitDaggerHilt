package com.evgeniykim.mvvmcoroutinelivedataretrofitdaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.evgeniykim.mvvmcoroutinelivedataretrofitdaggerhilt.adapter.TvShowAdapter
import com.evgeniykim.mvvmcoroutinelivedataretrofitdaggerhilt.databinding.ActivityMainBinding
import com.evgeniykim.mvvmcoroutinelivedataretrofitdaggerhilt.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: TvShowViewModel by viewModels()
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRv()
    }

    private fun setUpRv() {
        tvShowAdapter = TvShowAdapter()

        binding.recyclerView.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL, false
            )

            setHasFixedSize(true)
        }

        viewModel.responseTvShow.observe(this, { listTvShows ->
            tvShowAdapter.tvShows = listTvShows
        })
    }
}