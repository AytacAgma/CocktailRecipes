package com.example.cocktails.service

import com.example.cocktails.model.Cocktail
import io.reactivex.Single
import retrofit2.http.GET

//https://github.com/AytacAgma/CocktailRecipes/blob/master/app/cocktails.json

interface CocktailAPI {

    @GET("AytacAgma/CocktailRecipes/blob/master/app/cocktails.json")
    fun getCocktails() : Single<List<Cocktail>>
}