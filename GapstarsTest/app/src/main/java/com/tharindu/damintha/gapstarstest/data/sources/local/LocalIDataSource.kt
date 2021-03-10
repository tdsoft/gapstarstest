package com.tharindu.damintha.gapstarstest.data.sources.local

import com.tharindu.damintha.gapstarstest.GithubProfileQuery
import com.tharindu.damintha.gapstarstest.data.sources.IDataSource
import com.tharindu.damintha.gapstarstest.data.sources.Result
import javax.inject.Inject

class LocalIDataSource @Inject constructor() : IDataSource {
    override suspend fun getProfileData(): Result<GithubProfileQuery.Data> {
        TODO("Not yet implemented")
    }

    override fun clearCache() {
        TODO("Not yet implemented")
    }
}