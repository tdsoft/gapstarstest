package com.tharindu.damintha.gapstarstest.data.sources

import com.tharindu.damintha.gapstarstest.data.sources.local.LocalIDataSource
import com.tharindu.damintha.gapstarstest.data.sources.remote.RemoteIDataSource
import javax.inject.Inject

class GTRepository @Inject constructor(
    private val remoteDataSource: RemoteIDataSource,
    private val localDataSource: LocalIDataSource
) : IDataSource {
    override suspend fun getProfileData() = remoteDataSource.getProfileData()

    override fun clearCache() {
        remoteDataSource.clearCache()
    }
}