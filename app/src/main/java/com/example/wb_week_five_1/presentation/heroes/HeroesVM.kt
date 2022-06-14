package com.example.wb_week_five_1.presentation.heroes

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wb_week_five_1.data.HeroRepositoryImp
import com.example.wb_week_five_1.data.HeroRepositoryImp.Companion.FILE_DOTA_HEROES
import com.example.wb_week_five_1.domain.GetHeroListUseCase
import com.example.wb_week_five_1.domain.Hero
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File

class HeroesVM : ViewModel() {

    var heroesList: LiveData<List<Hero>> = MutableLiveData(listOf())

    fun onCreate(context: Context) {
        val repository = HeroRepositoryImp(context)
        val getHeroListUseCase = GetHeroListUseCase(repository)
        val file = File(context.filesDir, FILE_DOTA_HEROES)

        viewModelScope.launch {
            if (!file.exists()) {
                heroesList = getHeroListUseCase.getHeroListFromAPI()
                delay(1000L)
                getHeroListUseCase.addHeroListToFile()
            } else {
                heroesList = getHeroListUseCase.getHeroesFromFile()
            }
        }
    }
}