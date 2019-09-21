package com.yucelt.sahibindentechchallange.android.di.module

import android.app.Application
import androidx.room.Room
import com.yucelt.sahibindentechchallange.android.base.room.AppDatabase
import com.yucelt.sahibindentechchallange.android.base.room.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).allowMainThreadQueries().build()
    }


    @Provides
    internal fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao
    }
}