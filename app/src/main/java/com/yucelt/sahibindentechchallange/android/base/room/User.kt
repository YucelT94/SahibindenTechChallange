package com.yucelt.sahibindentechchallange.android.base.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
@Entity(tableName = "User")
data class User(
    @PrimaryKey var id: Long,
    var name: String,
    var password: String
)