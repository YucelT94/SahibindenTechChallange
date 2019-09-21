package com.yucelt.sahibindentechchallange.android.base.network

import io.reactivex.Single

/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */
interface ApiTask<Response : BaseResponse?, Request : BaseRequest?> {
    fun execute(request: Request): Single<Response>
}
