package com.yucelt.sahibindentechchallange.android.feature.myorders.presentation

import androidx.lifecycle.ViewModel
import com.yucelt.sahibindentechchallange.android.feature.myorders.domain.MyOrdersRepository
import javax.inject.Inject

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
class MyOrdersViewModel
@Inject constructor(private val repository: MyOrdersRepository) : ViewModel() {
    private val TAG = MyOrdersViewModel::class.java.simpleName

}