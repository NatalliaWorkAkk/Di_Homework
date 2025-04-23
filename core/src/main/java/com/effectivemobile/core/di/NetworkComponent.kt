package com.effectivemobile.core.di

import dagger.Component
import retrofit2.Retrofit

@Component(modules = [RetrofitModule::class])
interface NetworkComponent {

    @Test
    fun testRetrofit(): Retrofit
    @Prod
    fun prodRetrofit(): Retrofit
}