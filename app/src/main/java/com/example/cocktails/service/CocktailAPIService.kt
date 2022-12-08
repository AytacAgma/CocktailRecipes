package com.example.cocktails.service

import com.example.cocktails.model.Cocktail
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CocktailAPIService {

    //https://www.thecocktaildb.com/api/json/v1/1/search.php?f=a

    private val BASE_URL = "https://www.thecocktaildb.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CocktailAPI::class.java)

    fun getData() : Single<List<Cocktail>> {
        return api.getCocktails()
    }

}