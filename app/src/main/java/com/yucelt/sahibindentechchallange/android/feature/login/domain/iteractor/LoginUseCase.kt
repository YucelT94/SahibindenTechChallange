package com.yucelt.sahibindentechchallange.android.feature.login.domain.iteractor

import com.yucelt.sahibindentechchallange.android.base.domain.UseCase
import com.yucelt.sahibindentechchallange.android.base.room.User
import com.yucelt.sahibindentechchallange.android.feature.login.domain.LoginRepository
import javax.inject.Inject

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
class LoginUseCase @Inject constructor(private val repository: LoginRepository) :
    UseCase() {

    fun getUser() = repository.getUser()

    fun insert(user: User) = repository.insert(user)

    fun updateUser(id: Long, rememberMe: Boolean) = repository.updateUser(id, rememberMe)
}