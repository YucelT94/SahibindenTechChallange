package com.yucelt.sahibindentechchallange.android.base.basecomponent

/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */
abstract class BaseComponentViewModel<ViewData> {

    abstract fun handleInput(viewData: ViewData?)
}