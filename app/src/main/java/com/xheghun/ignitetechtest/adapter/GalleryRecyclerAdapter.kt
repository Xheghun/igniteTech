package com.xheghun.ignitetechtest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xheghun.ignitetechtest.R

class GalleryRecyclerAdapter(private var context: Context) : RecyclerView.Adapter<GalleryRecyclerAdapter.GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(LayoutInflater.from(context).inflate(R.layout.gallery_rc_item,parent,false))
    }

    override fun getItemCount(): Int {
        return 12
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        Glide.with(context).load(R.drawable.gallery_item).override(holder.imageView.width,holder.imageView.height)
            .into(holder.imageView)
    }

    class GalleryViewHolder(itemLayout: View) : RecyclerView.ViewHolder(itemLayout) {
        var imageView:ImageView = itemLayout.findViewById(R.id.gallery_image)

    }
}