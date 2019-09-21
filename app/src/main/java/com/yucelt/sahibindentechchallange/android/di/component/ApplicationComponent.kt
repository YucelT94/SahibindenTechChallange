package com.yucelt.sahibindentechchallange.android.di.component

import android.app.Application
import com.yucelt.sahibindentechchallange.android.MainApplication
import com.yucelt.sahibindentechchallange.android.di.module.ActivityModule
import com.yucelt.sahibindentechchallange.android.di.module.ApplicationModule
import com.yucelt.sahibindentechchallange.android.di.module.DatabaseModule
import com.yucelt.sahibindentechchallange.android.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        DatabaseModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: MainApplication)
}