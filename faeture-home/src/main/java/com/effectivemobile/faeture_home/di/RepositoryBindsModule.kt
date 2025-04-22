package com.effectivemobile.faeture_home.di

import com.effectivemobile.faeture_home.data.NetworkRepositoryImpl
import com.effectivemobile.faeture_home.domain.NetworkRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBindsModule {

    @Binds
    abstract fun bindNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository
}