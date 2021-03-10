package com.tharindu.damintha.gapstarstest.di

import android.content.Context
import android.content.SharedPreferences
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.cache.http.HttpCachePolicy
import com.apollographql.apollo.cache.http.ApolloHttpCache
import com.apollographql.apollo.cache.http.DiskLruHttpCacheStore
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.tharindu.damintha.gapstarstest.MyApp
import com.tharindu.damintha.gapstarstest.utils.AuthorizationInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object GTModule {


    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor())
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun provideApollo(client: OkHttpClient): ApolloClient {
        val file = File(MyApp.instance.cacheDir, "apolloCache")

        // Size in bytes of the cache
        val size: Long = 1024 * 1024

        // Create the http response cache store
        val cacheStore = DiskLruHttpCacheStore(file, size)

        return ApolloClient.builder()
            .httpCache(ApolloHttpCache(cacheStore))
            .defaultHttpCachePolicy(HttpCachePolicy.CACHE_FIRST.expireAfter(1, TimeUnit.DAYS))
            .serverUrl("https://api.github.com/graphql")
            .okHttpClient(client).build()
    }


    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("GapstarsPref", Context.MODE_PRIVATE)
    }

}