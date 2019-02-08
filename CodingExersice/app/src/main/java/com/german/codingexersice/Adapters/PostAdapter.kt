package com.german.codingexersice.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.german.codingexersice.Adapters.ViewHolders.PostViewHolder
import com.german.codingexersice.DataClasses.post
import com.german.codingexersice.R

class PostAdapter(private  val context: Context, private val posts:List<post>) :  RecyclerView.Adapter<PostViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        return PostViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.setup(posts[position])

    }

    override fun getItemCount(): Int {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    return posts.size

    }




}