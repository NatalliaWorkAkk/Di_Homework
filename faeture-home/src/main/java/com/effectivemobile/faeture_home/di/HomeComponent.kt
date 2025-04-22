package com.effectivemobile.faeture_home.di

import com.effectivemobile.core.di.NetworkComponent
import com.effectivemobile.faeture_home.presentation.HomeFragment
import dagger.Component

@Component(modules = [RepositoryBindsModule::class], dependencies = [NetworkComponent::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Component.Builder
    interface Builder {

        fun networkDeps(deps: NetworkComponent): Builder

        fun build(): HomeComponent
    }
}