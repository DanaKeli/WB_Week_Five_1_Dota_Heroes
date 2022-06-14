package com.example.wb_week_five_1.domain

import androidx.lifecycle.LiveData

class GetHeroListUseCase(private val heroRepository: HeroRepository) {

    fun getHeroListFromAPI(): LiveData<List<Hero>> {
        return heroRepository.getHeroListFromAPI()
    }

    fun getHeroesFromFile(): LiveData<List<Hero>> {
        return heroRepository.getHeroListFromFile()
    }

    fun addHeroListToFile() {
        heroRepository.addHeroListToFile()
    }
}