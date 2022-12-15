package com.example.cocktails.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktails.model.Cocktail

class CocktailDetailsViewModel : ViewModel() {

    val cocktailLiveData = MutableLiveData<Cocktail>()

    fun getDataFromRoom(){
        val cocktail = Cocktail("1","1","1","https://www.aytacagma.com/images/CVfototwit.PNG","1","1","1","1","1","1","1","1","1")
        cocktailLiveData.value = cocktail
    }
}