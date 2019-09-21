package com.yucelt.sahibindentechchallange.android.base.room

import androidx.room.*

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User): Long

    @Query("SELECT * FROM User")
    fun getUser(): User

    @Update
    fun updateUser(photo: User)

}