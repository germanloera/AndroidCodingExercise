package com.german.codingexersice.WebServices

import com.german.codingexersice.DataClasses.comment
import com.german.codingexersice.DataClasses.post
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {




    @GET("/posts/")
    fun loadPosts() : Observable<List<post>>

    @GET("/comments")
    fun loadPostComents(@Query("postId")  postId:String) : Observable<List<comment>>



    companion object {
        fun create(): ApiServices{

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com")

                    .build()

            return retrofit.create(ApiServices::class.java)

        }
    }


}