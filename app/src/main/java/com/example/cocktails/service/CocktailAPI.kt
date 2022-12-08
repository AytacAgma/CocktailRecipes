package com.example.cocktails.service

import com.example.cocktails.model.Cocktail
import io.reactivex.Single
import retrofit2.http.GET

//https://www.thecocktaildb.com/api/json/v1/1/search.php?f=a

interface CocktailAPI {

    @GET("api/json/v1/1/search.php?f=a")
    fun getCocktails() : Single<List<Cocktail>>
}