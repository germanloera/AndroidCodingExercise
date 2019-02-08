package com.german.codingexersice.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.german.codingexersice.Adapters.ViewHolders.CommentViewHolder
import com.german.codingexersice.Adapters.ViewHolders.PostViewHolder
import com.german.codingexersice.DataClasses.comment
import com.german.codingexersice.DataClasses.post
import com.german.codingexersice.R

class CommentsAdapter(private  val context: Context, private val comments:List<comment>) :  RecyclerView.Adapter<CommentViewHolder>(){




    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.setup(comments[position])
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {

        return CommentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }



    override fun getItemCount(): Int {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    return comments.size

    }




}