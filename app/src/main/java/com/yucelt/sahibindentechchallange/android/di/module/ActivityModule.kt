package com.yucelt.sahibindentechchallange.android.di.module

import com.yucelt.sahibindentechchallange.android.di.provider.MyOrdersActivityProvider
import com.yucelt.sahibindentechchallange.android.feature.myorders.presentation.MyOrdersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivityModule {

    @ContributesAndroidInjector(modules = [MyOrdersActivityProvider::class])
    fun myOrdersActivityInjector(): MyOrdersActivity

    //TODO: Activity'leri ekle

}