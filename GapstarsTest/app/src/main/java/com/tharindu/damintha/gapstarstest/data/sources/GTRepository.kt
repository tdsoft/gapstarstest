package com.tharindu.damintha.gapstarstest.data.sources

import androidx.lifecycle.liveData
import com.tharindu.damintha.gapstarstest.GithubProfileQuery
import com.tharindu.damintha.gapstarstest.data.sources.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import okhttp3.Response
import javax.inject.Inject

class GTRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {
    fun getProfileData() = resultLiveData { remoteDataSource.getProfileData() }

}