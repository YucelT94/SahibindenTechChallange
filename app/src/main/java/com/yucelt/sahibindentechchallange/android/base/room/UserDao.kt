package com.yucelt.sahibindentechchallange.android.base.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User): Long

    @Query("SELECT * FROM User")
    fun getUser(): User

    @Query("UPDATE User SET rememberMe = :remember WHERE id = :id")
    fun updateUser(id: Long, remember: Boolean): Int
}