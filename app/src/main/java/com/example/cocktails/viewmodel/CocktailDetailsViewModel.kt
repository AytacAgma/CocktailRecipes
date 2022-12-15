package com.example.cocktails.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktails.model.Cocktail

class CocktailDetailsViewModel : ViewModel() {

    val cocktailLiveData = MutableLiveData<Cocktail>()

    fun getDataFromRoom(){
        val deneme = Cocktail("1","1","1","1","1","1","1","1","1","1","1","1","1")
        cocktailLiveData.value = deneme
    }
}