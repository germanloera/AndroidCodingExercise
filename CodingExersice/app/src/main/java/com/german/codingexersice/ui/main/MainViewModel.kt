package com.german.codingexersice.ui.main

import android.arch.lifecycle.ViewModel
import com.german.codingexersice.DataClasses.post
import com.german.codingexersice.WebServices.ApiServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel


  var posts = listOf<post>()
    val apiService by lazy {
        ApiServices.create()
    }

    var disposable: Disposable? = null


     fun loadPost(unit: (List<post>) -> Unit){


         disposable = apiService.loadPosts()//LoadNearbyPlaces(location, radius, "food", key)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe( {result -> posts = result
                                        unit(result)
                            },
                         {error -> error.printStackTrace()
                              })


     }







}
