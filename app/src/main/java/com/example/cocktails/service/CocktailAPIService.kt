package com.example.cocktails.service

import com.example.cocktails.model.Cocktail
import com.google.gson.GsonBuilder
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class CocktailAPIService {

    //https://github.com/AytacAgma/CocktailRecipes/blob/master/app/cocktails.json

    private val BASE_URL = "https://github.com/"

    var gson = GsonBuilder()
        .setLenient()
        .create()

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CocktailAPI::class.java)

    fun getData() : Single<List<Cocktail>> {
        return api.getCocktails()
    }

}