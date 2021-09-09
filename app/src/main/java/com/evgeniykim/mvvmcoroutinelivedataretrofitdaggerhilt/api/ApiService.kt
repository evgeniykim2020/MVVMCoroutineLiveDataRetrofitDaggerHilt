package com.evgeniykim.mvvmcoroutinelivedataretrofitdaggerhilt.api

import android.provider.SyncStateContract
import com.evgeniykim.mvvmcoroutinelivedataretrofitdaggerhilt.helper.Constants
import com.evgeniykim.mvvmcoroutinelivedataretrofitdaggerhilt.model.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.BASE_URL)
    suspend fun getTvShows():Response<TvShowResponse>
}