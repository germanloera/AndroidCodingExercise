package com.german.codingexersice.Adapters.ViewHolders

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.german.codingexersice.CommentsActivity
import com.german.codingexersice.DataClasses.post
import com.german.codingexersice.R
import kotlinx.android.synthetic.main.item_layout.view.*

class PostViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {


    fun setup(post: post){



        itemView.tv_title_name.text = post.title;
        itemView.tv_body.text = post.body

        itemView.setOnClickListener {
            view: View? ->

            var intent = Intent(itemView.context, CommentsActivity::class.java)
            intent.putExtra("postId", post.id)

            itemView.context.startActivity(intent)



        }


    }



}