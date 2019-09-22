package com.yucelt.sahibindentechchallange.android.di.builder

import androidx.lifecycle.ViewModel
import com.yucelt.sahibindentechchallange.android.di.ViewModelKey
import com.yucelt.sahibindentechchallange.android.feature.login.presentation.LoginViewModel
import com.yucelt.sahibindentechchallange.android.feature.myorders.presentation.MyOrdersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
@Module
abstract class ViewModelsBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(MyOrdersViewModel::class)
    abstract fun bindMyOrdersViewModel(myOrdersViewModel: MyOrdersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel
}