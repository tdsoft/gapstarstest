package com.tharindu.damintha.gapstarstest.di

import android.content.Context
import android.content.SharedPreferences
import com.apollographql.apollo.ApolloClient
import com.facebook.stetho.okhttp3.StethoInterceptor
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
        return OkHttpClient.Builder().addNetworkInterceptor(StethoInterceptor()).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): ApolloClient {
        return ApolloClient.builder().serverUrl("http://app.efficienteg.com/api/")
            .okHttpClient(client).build()
    }


    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("EEGPref", Context.MODE_PRIVATE)
    }

//    @Singleton
//    @Provides
//    fun provideEEGDatabase(@ApplicationContext context: Context): EEGDatabase {
//        return Room.databaseBuilder(context, EEGDatabase::class.java, "eegdatabase.db")
//            .fallbackToDestructiveMigration()
//            .build()
//    }
}