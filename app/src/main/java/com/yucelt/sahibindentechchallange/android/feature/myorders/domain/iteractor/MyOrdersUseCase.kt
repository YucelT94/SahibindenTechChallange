package com.yucelt.sahibindentechchallange.android.feature.myorders.domain.iteractor

import com.yucelt.sahibindentechchallange.android.base.domain.SingleUseCase
import com.yucelt.sahibindentechchallange.android.feature.myorders.data.response.MyOrdersResponse
import com.yucelt.sahibindentechchallange.android.feature.myorders.domain.MyOrdersRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
class MyOrdersUseCase @Inject constructor(private val repository: MyOrdersRepository) :
    SingleUseCase<List<MyOrdersResponse>>() {

    override fun buildUseCaseSingle(): Single<List<MyOrdersResponse>> {
        return repository.getMyOrders()
    }

    fun updateUser(id: Long, rememberMe: Boolean) = repository.updateUser(id, rememberMe)
}