package com.tharindu.damintha.gapstarstest.data.sources

import com.tharindu.damintha.gapstarstest.GithubProfileQuery

interface IDataSource {
    suspend fun getProfileData(): Result<GithubProfileQuery.Data>
    fun clearCache()
}
