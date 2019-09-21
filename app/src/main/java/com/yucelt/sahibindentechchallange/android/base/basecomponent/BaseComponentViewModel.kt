package com.yucelt.sahibindentechchallange.android.base.basecomponent

import androidx.lifecycle.ViewModel

/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */
abstract class BaseComponentViewModel<ViewData> : ViewModel(){

    abstract fun handleInput(viewData: ViewData?)
}
