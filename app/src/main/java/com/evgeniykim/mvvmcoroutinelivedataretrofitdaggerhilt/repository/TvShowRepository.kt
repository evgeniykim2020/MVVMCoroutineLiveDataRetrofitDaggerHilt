package com.evgeniykim.mvvmcoroutinelivedataretrofitdaggerhilt.repository

import com.evgeniykim.mvvmcoroutinelivedataretrofitdaggerhilt.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject
constructor(private val apiService: ApiService){
    suspend fun getTvShows() = apiService.getTvShows()
}