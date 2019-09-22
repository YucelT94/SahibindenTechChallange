package com.yucelt.sahibindentechchallange.android.feature.login.domain

import com.yucelt.sahibindentechchallange.android.base.room.User

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
interface LoginRepository {
    /**
     * Create user
     */
    fun insert(user: User): Long

    /**
     * Get user
     */
    fun getUser(): User

    /**
     * Update user at database
     */
    fun updateUser(id: Long, rememberMe: Boolean): Int

}