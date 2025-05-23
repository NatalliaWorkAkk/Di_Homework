package com.effectivemobile.dihomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context (context: Context): Builder

        fun build(): AppComponent
    }
}