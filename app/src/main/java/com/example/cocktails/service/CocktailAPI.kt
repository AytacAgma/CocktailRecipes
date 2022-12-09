package com.example.cocktails.service

import com.example.cocktails.model.Cocktail
import io.reactivex.Single
import retrofit2.http.GET

//https://raw.githubusercontent.com/AytacAgma/CocktailRecipes/master/app/cocktails.json

interface CocktailAPI {

    @GET("AytacAgma/CocktailRecipes/master/app/cocktails.json")
    fun getCocktails() : Single<List<Cocktail>>
}