package com.example.wb_week_five_1.domain

import androidx.lifecycle.LiveData

interface HeroRepository {

    fun getHeroListFromAPI(): LiveData<List<Hero>>

    fun getHeroListFromFile(): LiveData<List<Hero>>

    fun addHeroListToFile()
}