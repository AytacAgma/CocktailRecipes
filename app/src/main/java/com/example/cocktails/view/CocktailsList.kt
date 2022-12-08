package com.example.cocktails.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktails.R
import com.example.cocktails.adapter.CocktailRecyclerAdapter
import com.example.cocktails.viewmodel.CocktailsListViewModel
import kotlinx.android.synthetic.main.activity_cocktails_list.*

class CocktailsList : AppCompatActivity() {

    private  lateinit var viewModel : CocktailsListViewModel
    private val recyclerCocktailAdapter = CocktailRecyclerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktails_list)

        viewModel = ViewModelProvider(this).get(CocktailsListViewModel::class.java)
        viewModel.refreshData()

        cocktailListRecyclerView.layoutManager = LinearLayoutManager(this)
        cocktailListRecyclerView.adapter = recyclerCocktailAdapter

        observeLiveData()

    }

    fun observeLiveData(){
        viewModel.cocktails.observe(this, Observer {
            it?.let {

                cocktailListRecyclerView.visibility = View.VISIBLE
                recyclerCocktailAdapter.updateCocktailList(it)
            }
        })

        viewModel.errorMessage.observe(this, Observer {
            it?.let {
                if (it) {
                    cocktailListErrorMsg.visibility = View.VISIBLE
                    cocktailListRecyclerView.visibility = View.GONE
                }
                else{
                    cocktailListErrorMsg.visibility = View.GONE
                }
            }
        })

        viewModel.loading.observe(this, Observer {
            it?.let {
                if(it){
                    cocktailListRecyclerView.visibility = View.GONE
                    cocktailListErrorMsg.visibility = View.GONE
                    cocktailListLoading.visibility = View.VISIBLE
                }
                else{
                    cocktailListLoading.visibility = View.GONE
                }

            }
        })

    }
}