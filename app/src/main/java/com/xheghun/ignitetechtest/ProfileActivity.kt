package com.xheghun.ignitetechtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.xheghun.ignitetechtest.adapter.GalleryRecyclerAdapter
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val intent = intent

        email_address.text = intent.getStringExtra("email")

        gallery_rc.adapter = GalleryRecyclerAdapter(this)
        gallery_rc.layoutManager = GridLayoutManager(this,3)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        Glide.with(this).load(R.drawable.profile_pic).override(profile_img.width,profile_img.height)
            .into(profile_img)
    }
}
