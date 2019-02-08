package com.german.codingexersice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.german.codingexersice.ui.comments.CommentsFragment

class CommentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comments_activity)
        this.title = "Comments"
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CommentsFragment.newInstance())
                    .commitNow()
        }
    }

}
