package com.yucelt.sahibindentechchallange.android.feature.login.data.repo

import com.yucelt.sahibindentechchallange.android.base.room.AppDatabase
import com.yucelt.sahibindentechchallange.android.base.room.User
import com.yucelt.sahibindentechchallange.android.feature.login.domain.LoginRepository

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
class LoginDataRepository(
    private val database: AppDatabase
) : LoginRepository {
    override fun insert(user: User): Long = database.userDao.insert(user)

    override fun getUser() = database.userDao.getUser()

    override fun updateUser(id: Long, rememberMe: Boolean) =
        database.userDao.updateUser(id, rememberMe)
}