package com.german.codingexersice.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.german.codingexersice.Adapters.PostAdapter
import com.german.codingexersice.DataClasses.post
import com.german.codingexersice.R
import com.german.codingexersice.WebServices.ApiServices
import io.reactivex.disposables.Disposable

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }






    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }






    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)



       if( viewModel.posts.isEmpty()) {

           viewModel.loadPost { posts: List<post> ->
               SetupRecyclerView(posts)
           }

       }else{

           SetupRecyclerView(viewModel.posts)
       }


    }


    fun SetupRecyclerView(posts: List<post>){
        var rv_items = view?.findViewById<RecyclerView>(R.id.rv_items);
        rv_items?.layoutManager = LinearLayoutManager(this.context)
        rv_items?.adapter = PostAdapter(this.requireContext(), posts)



    }







}
