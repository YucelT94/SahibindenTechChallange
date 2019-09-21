package com.yucelt.sahibindentechchallange.android.di.builder

import androidx.lifecycle.ViewModelProvider
import com.yucelt.sahibindentechchallange.android.di.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
@Module(includes = [(ViewModelsBuilder::class)])
abstract class ViewModelFactoryBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}