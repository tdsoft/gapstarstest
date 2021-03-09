package com.tharindu.damintha.gapstarstest.di

import android.content.Context
import android.content.SharedPreferences
import com.apollographql.apollo.ApolloClient
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.tharindu.damintha.gapstarstest.utils.AuthorizationInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
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
        return ApolloClient.builder().serverUrl("https://api.github.com/graphql")
            .okHttpClient(client).build()
    }


    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("GapstarsPref", Context.MODE_PRIVATE)
    }

//    @Singleton
//    @Provides
//    fun provideEEGDatabase(@ApplicationContext context: Context): GTDatabase {
//        return Room.databaseBuilder(context, EEGDatabase::class.java, "gapstarts.db")
//            .fallbackToDestructiveMigration()
//            .build()
//    }
}