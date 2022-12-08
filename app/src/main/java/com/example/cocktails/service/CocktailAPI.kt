package com.example.cocktails.service

import com.example.cocktails.model.Cocktail
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

//www.thecocktaildb.com/api/json/v1/1/search.php?f=a

interface CocktailAPI {

    @GET("www.thecocktaildb.com/api/json/v1/1/search.php?f=a")
    fun getCocktails() : Single<List<Cocktail>>
}