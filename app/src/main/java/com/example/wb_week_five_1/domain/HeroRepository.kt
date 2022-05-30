package com.example.wb_week_five_1.domain

import androidx.lifecycle.LiveData

interface HeroRepository {

    fun getHeroList(): LiveData<List<Hero>>
}