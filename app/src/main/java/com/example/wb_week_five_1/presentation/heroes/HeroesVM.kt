package com.example.wb_week_five_1.presentation.heroes

import androidx.lifecycle.ViewModel
import com.example.wb_week_five_1.data.HeroRepositoryImp
import com.example.wb_week_five_1.domain.GetHeroListUseCase

class HeroesVM : ViewModel() {

    private val repository = HeroRepositoryImp()
    private val getHeroListUseCase = GetHeroListUseCase(repository)

    val heroesList = getHeroListUseCase.getHeroList()
}