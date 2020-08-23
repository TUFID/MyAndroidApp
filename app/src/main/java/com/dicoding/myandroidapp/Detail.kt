package com.dicoding.myandroidapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Detail : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvSetName: TextView = findViewById(R.id.tv_item_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetDetails: TextView = findViewById(R.id.tv_item_detail)

        val tvName = intent.getStringExtra(EXTRA_NAME)
        val imgPhoto = intent.getIntExtra(EXTRA_PHOTO, 0)
        val tvDetail = intent.getStringExtra(EXTRA_DETAIL)

        tvSetName.text = tvName
        Glide.with(this)
            .load(imgPhoto)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetDetails.text = tvDetail



    }
}
