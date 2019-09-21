package com.yucelt.sahibindentechchallange.android.di.builder

import androidx.lifecycle.ViewModel
import com.yucelt.sahibindentechchallange.android.di.ViewModelKey
import com.yucelt.sahibindentechchallange.android.feature.myorders.presentation.MyOrdersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
@Module
abstract class ViewModelsBuilder {
    // TODO: ViewModelleri ekle

    @Binds
    @IntoMap
    @ViewModelKey(MyOrdersViewModel::class)
    abstract fun bindMyOrdersViewModel(albumsViewModel: MyOrdersViewModel): ViewModel
}