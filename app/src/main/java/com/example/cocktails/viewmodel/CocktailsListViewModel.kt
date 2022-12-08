package com.example.cocktails.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktails.model.Cocktail
import com.example.cocktails.service.CocktailAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_cocktails_list.*

class CocktailsListViewModel : ViewModel() {

    val cocktails = MutableLiveData<List<Cocktail>>()
    val errorMessage = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    private val cocktailAPIService = CocktailAPIService()
    private val disposable = CompositeDisposable()

    fun refreshData() {
        getWithAPI()

    }

    private fun getWithAPI() {
        //progressbar true yapıldı +
        loading.value = true
        errorMessage.value = false

        disposable.add(
            cocktailAPIService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Cocktail>>() {
                    override fun onSuccess(t: List<Cocktail>) {
                        cocktails.value = t
                        errorMessage.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        errorMessage.value = true
                        e.printStackTrace()
                        loading.value = false
                    }

                })
        )

    }
}