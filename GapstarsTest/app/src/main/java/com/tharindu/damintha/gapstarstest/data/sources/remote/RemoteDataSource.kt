package com.tharindu.damintha.gapstarstest.data.sources.remote

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.tharindu.damintha.gapstarstest.GithubProfileQuery
import com.tharindu.damintha.gapstarstest.base.BaseDataSource
import com.tharindu.damintha.gapstarstest.data.sources.Result
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apolloClient: ApolloClient) :
    BaseDataSource() {

    suspend fun getProfileData(): Result<GithubProfileQuery.Data> {
        return getResult {
            apolloClient
                .query(GithubProfileQuery())
                .await()
        }
    }

    fun clearCache() {
        apolloClient.clearHttpCache()
    }
}