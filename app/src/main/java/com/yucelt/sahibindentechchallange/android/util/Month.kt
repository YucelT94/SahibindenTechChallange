package com.yucelt.sahibindentechchallange.android.util

import com.google.gson.annotations.SerializedName

enum class Month(val month: String){
    @SerializedName("Ocak")
    ocak("1"),

    @SerializedName("Şubat")
    subat("2"),

    @SerializedName("Mart")
    mart("3"),

    @SerializedName("Nisan")
    nisan("4"),

    @SerializedName("Mayıs")
    mayis("5"),

    @SerializedName("Haziran")
    haziran("6"),

    @SerializedName("Temmuz")
    temmuz("7"),

    @SerializedName("Ağustos")
    agustos("8"),

    @SerializedName("Eylül")
    eylul("9"),

    @SerializedName("Ekim")
    ekim("10"),

    @SerializedName("Kasım")
    kasim("11"),

    @SerializedName("Aralık")
    aralik("12");
}