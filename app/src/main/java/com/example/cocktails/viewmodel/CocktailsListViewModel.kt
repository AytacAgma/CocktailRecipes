package com.example.cocktails.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktails.model.Cocktail
import com.example.cocktails.service.CocktailAPIService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class CocktailsListViewModel : ViewModel() {

    val cocktails = MutableLiveData<List<Cocktail>>()
    val errorMessage = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    private val cocktailAPIService = CocktailAPIService()
    private val disposable = CompositeDisposable()

    fun refreshData(){
        getWithAPI()

    }

    private fun getWithAPI(){
        //progressbar true yapılacak

        disposable.add(
            cocktailAPIService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Cocktail>>(){
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