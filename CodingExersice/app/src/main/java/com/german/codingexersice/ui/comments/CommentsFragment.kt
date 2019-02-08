package com.german.codingexersice.ui.comments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.german.codingexersice.Adapters.CommentsAdapter
import com.german.codingexersice.Adapters.PostAdapter
import com.german.codingexersice.DataClasses.comment
import com.german.codingexersice.DataClasses.post
import com.german.codingexersice.R

class CommentsFragment : Fragment() {

    companion object {
        fun newInstance() = CommentsFragment()
    }

    private lateinit var viewModel: CommentsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.comments_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CommentsViewModel::class.java)


        if( viewModel.comments.isEmpty()) {

            viewModel.loadComments("1") { comments: List<comment> ->
                setupRecyclerView(comments)
            }

        }else{

            setupRecyclerView(viewModel.comments)
        }





        // TODO: Use the ViewModel
    }



    fun setupRecyclerView(comments:List<comment>){

        var rv_items = view?.findViewById<RecyclerView>(R.id.rv_comments);
        rv_items?.layoutManager = LinearLayoutManager(this.context)
        rv_items?.adapter = CommentsAdapter(this.requireContext(), comments)


    }









}
