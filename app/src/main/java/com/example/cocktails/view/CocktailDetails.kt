package com.example.cocktails.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cocktails.R
import com.example.cocktails.util.makePlaceholder
import com.example.cocktails.util.show
import com.example.cocktails.viewmodel.CocktailDetailsViewModel
import kotlinx.android.synthetic.main.activity_cocktail_details.*

class CocktailDetails : AppCompatActivity() {
    private lateinit var viewModel: CocktailDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_details)

        viewModel = ViewModelProviders.of(this).get(CocktailDetailsViewModel::class.java)
        viewModel.getDataFromRoom()

        val b = intent.extras
        val name = b!!.getString("name")
        println(name)
        val image = b!!.getString("image")

        observeLiveData(name, image)
    }

    fun observeLiveData(name : String?, image : String?){

        viewModel.cocktailLiveData.observe(this, Observer {cocktail->

            cocktail?.let {
                txtDetailName.text = name
                txtDetailType.text = it.type
                txtIngredient1.text = it.ingredient1
                txtIngredient2.text = it.ingredient2
                txtIngredient3.text = it.ingredient3
                txtIngredient4.text = it.ingredient4
                txtHowTo.text = it.howTo
                imgDetailCocktail.show(image, makePlaceholder(this))
            }
        })
    }
}