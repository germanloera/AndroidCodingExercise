package com.german.codingexersice.ui.comments

import android.arch.lifecycle.ViewModel
import com.german.codingexersice.DataClasses.comment
import com.german.codingexersice.DataClasses.post
import com.german.codingexersice.WebServices.ApiServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CommentsViewModel : ViewModel() {


    var comments = listOf<comment>()
    val apiService by lazy {
        ApiServices.create()
    }

    var disposable: Disposable? = null


    fun loadComments( postId:String, unit: (List<comment>) -> Unit){


        disposable = apiService.loadPostComents(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {result -> comments = result
                    unit(result)
                },
                        {error -> error.printStackTrace()
                        })


    }


}
