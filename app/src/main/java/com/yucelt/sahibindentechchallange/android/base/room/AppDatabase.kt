package com.yucelt.sahibindentechchallange.android.base.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object {
        val DB_NAME = "SahibindenChallange.db"
    }
}