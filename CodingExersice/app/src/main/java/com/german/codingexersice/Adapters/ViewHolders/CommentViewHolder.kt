package com.german.codingexersice.Adapters.ViewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.german.codingexersice.DataClasses.comment
import com.german.codingexersice.DataClasses.post
import com.german.codingexersice.R
import kotlinx.android.synthetic.main.item_layout.view.*

class CommentViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {


    fun setup(comment: comment){


        itemView.tv_email.visibility = View.VISIBLE;
        itemView.tv_email_separator.visibility = View.VISIBLE;
        itemView.tv_email.text = comment.email;
        itemView.tv_body.text = comment.body;
        itemView.tv_title_name.text = comment.name;







    }



}