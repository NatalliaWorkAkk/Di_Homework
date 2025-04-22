package com.effectivemobile.core.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
object RetrofitModule {

    @Provides
    @Singleton
    @Prod
    fun provideProdApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://prod.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    })
                    .build()
            )
            .build()
    }

    @Provides
    @Singleton
    @Test
    fun provideTestApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    })
                    .build()
            )
            .build()
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Prod

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Test