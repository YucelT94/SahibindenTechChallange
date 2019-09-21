package com.yucelt.sahibindentechchallange.android.di.provider

import com.yucelt.sahibindentechchallange.android.feature.myorders.presentation.MyOrdersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
@Module
abstract class MyOrdersActivityProvider {

    @ContributesAndroidInjector
    abstract fun provideAlbumsFragmentProvider(): MyOrdersActivity

}