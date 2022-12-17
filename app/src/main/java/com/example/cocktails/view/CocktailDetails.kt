package com.example.cocktails.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cocktails.R
import com.example.cocktails.model.Cocktail
import com.example.cocktails.util.makePlaceholder
import com.example.cocktails.util.show
import com.example.cocktails.viewmodel.CocktailDetailsViewModel
import kotlinx.android.synthetic.main.activity_cocktail_details.*

class CocktailDetails : AppCompatActivity() {
    private lateinit var viewModel: CocktailDetailsViewModel
    //var name : String? = "initial"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_details)

        val b = intent.extras
        val cocktailDetail = Cocktail(
             b!!.getString("id")
            ,b!!.getString("name")
            ,b!!.getString("type")
            ,b!!.getString("image")
            ,b!!.getString("ingredient1")
            ,b!!.getString("ingredient2")
            ,b!!.getString("ingredient3")
            ,b!!.getString("ingredient4")
            ,b!!.getString("measure1")
            ,b!!.getString("measure2")
            ,b!!.getString("measure3")
            ,b!!.getString("measure4")
            ,b!!.getString("howTo"))

        viewModel = ViewModelProviders.of(this).get(CocktailDetailsViewModel::class.java)
        viewModel.getDataFromIntent(cocktailDetail)

        /*val b = intent.extras
        val name = b!!.getString("name")
        println(name)
        val image = b!!.getString("image")*/

        //observeLiveData(name, image)

        observeLiveData()
    }

    //fun observeLiveData(name : String?, image : String?){
    fun observeLiveData(){

        viewModel.cocktailLiveData.observe(this, Observer {cocktail->

            cocktail?.let {
                txtDetailName.text = it.name //name
                txtDetailType.text = it.type
                txtIngredient1.text = it.ingredient1
                txtIngredient2.text = it.ingredient2
                txtIngredient3.text = it.ingredient3
                txtIngredient4.text = it.ingredient4
                txtHowTo.text = it.howTo
                imgDetailCocktail.show(it.image, makePlaceholder(this)) //image
            }
        })
    }
}