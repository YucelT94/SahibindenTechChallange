package com.yucelt.sahibindentechchallange.android.feature.myorders.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yucelt.sahibindentechchallange.android.component.expandableitem.ExpandableItemViewData
import com.yucelt.sahibindentechchallange.android.feature.myorders.domain.iteractor.MyOrdersUseCase
import javax.inject.Inject

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
class MyOrdersViewModel
@Inject constructor(private val useCase: MyOrdersUseCase) : ViewModel() {
    private val TAG = MyOrdersViewModel::class.java.simpleName

    val adapterLiveData = MutableLiveData<List<ExpandableItemViewData>>()


    fun generataAdapterData() {
        useCase.execute(
            onSuccess = {
                adapterLiveData.postValue(it.map { item -> item.toExpandableItemViewData() })
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

    fun logOut() {
        useCase.updateUser(1, false)
    }
}