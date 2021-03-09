package com.tharindu.damintha.gapstarstest.data.sources

import com.tharindu.damintha.gapstarstest.data.sources.remote.RemoteDataSource
import javax.inject.Inject

class GTRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {
    fun getProfileData() = resultLiveData { remoteDataSource.getProfileData() }
    fun clearCache() {
        remoteDataSource.clearCache()
    }

}