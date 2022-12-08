package com.example.cocktails.model

import com.google.gson.annotations.SerializedName

data class Cocktail(
    @SerializedName("idDrink")
    val id: String?,
    @SerializedName("strDrink")
    val name: String?,
    @SerializedName("strAlcoholic")
    val type: String?,
    @SerializedName("strDrinkThumb")
    val image: String?,
    @SerializedName("strIngredient1")
    val ingredient1: String?,
    @SerializedName("strIngredient2")
    val ingredient2: String?,
    @SerializedName("strIngredient3")
    val ingredient3: String?,
    @SerializedName("strIngredient4")
    val ingredient4: String?,
    @SerializedName("strMeasure1")
    val measure1: String?,
    @SerializedName("strMeasure2")
    val measure2: String?,
    @SerializedName("strMeasure3")
    val measure3: String?,
    @SerializedName("strMeasure4")
    val measure4: String?,
    @SerializedName("strInstructions")
    val howTo: String?
    ) {
}