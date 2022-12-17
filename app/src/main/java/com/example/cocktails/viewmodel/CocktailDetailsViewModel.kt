package com.example.cocktails.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktails.model.Cocktail
import com.example.cocktails.view.CocktailDetails

class CocktailDetailsViewModel : ViewModel() {

    val cocktailLiveData = MutableLiveData<Cocktail>()

    fun getDataFromIntent(cocktailDetail:Cocktail){
        /*val details = CocktailDetails()
        println(details.name)*/

        val c = cocktailDetail

        val cocktail = Cocktail(c.id, c.name, c.type, c.image, c.ingredient1, c.ingredient2, c.ingredient3, c.ingredient4, c.measure1, c.measure2, c.measure3, c.measure4, c.howTo)
        cocktailLiveData.value = cocktail
    }
}