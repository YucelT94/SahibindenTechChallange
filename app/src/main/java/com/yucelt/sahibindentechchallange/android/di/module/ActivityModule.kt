package com.yucelt.sahibindentechchallange.android.di.module

import com.yucelt.sahibindentechchallange.android.feature.login.presentation.LoginActivity
import com.yucelt.sahibindentechchallange.android.feature.myorders.presentation.MyOrdersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivityModule {

    @ContributesAndroidInjector
    fun myOrdersActivityInjector(): MyOrdersActivity

    @ContributesAndroidInjector
    fun loginActivityInjector(): LoginActivity
}