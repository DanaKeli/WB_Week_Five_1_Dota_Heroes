package com.example.wb_week_five_1.domain

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val id: Int,
    @Json(name = "localized_name")
    val name: String,
    val img: String,
    @Json(name = "base_health")
    val health: Int,
    @Json(name = "base_mana")
    val mana: Int,
    val attack_range: Int
) : Parcelable