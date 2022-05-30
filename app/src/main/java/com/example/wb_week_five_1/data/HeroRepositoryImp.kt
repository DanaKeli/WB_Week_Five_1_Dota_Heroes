package com.example.wb_week_five_1.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wb_week_five_1.domain.Hero
import com.example.wb_week_five_1.domain.HeroRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.*
import java.io.IOException

class HeroRepositoryImp : HeroRepository {

    companion object {
        const val BASE_URL = "https://api.opendota.com"
        const val URL = "https://api.opendota.com/api/heroStats"
    }

    private val client = OkHttpClient()
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val listType = Types.newParameterizedType(List::class.java, Hero::class.java)
    private val jsonAdapter: JsonAdapter<List<Hero>> = moshi.adapter(listType)
    private val heroList = MutableLiveData<List<Hero>>()

    override fun getHeroList(): LiveData<List<Hero>> {

        val request = Request.Builder()
            .url(URL)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                heroList.postValue(jsonAdapter.fromJson(response.body!!.string()))
            }

            override fun onFailure(call: Call, e: IOException) {
            }
        })
        return heroList
    }
}