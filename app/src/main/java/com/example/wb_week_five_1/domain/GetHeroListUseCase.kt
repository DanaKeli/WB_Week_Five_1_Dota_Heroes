package com.example.wb_week_five_1.domain

import androidx.lifecycle.LiveData

class GetHeroListUseCase(private val heroRepository: HeroRepository) {

    fun getHeroList(): LiveData<List<Hero>> {
        return heroRepository.getHeroList()
    }
}