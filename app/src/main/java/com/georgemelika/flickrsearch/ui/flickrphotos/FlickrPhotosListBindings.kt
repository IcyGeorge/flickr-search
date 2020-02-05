package com.georgemelika.flickrsearch.ui.flickrphotos

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.georgemelika.flickrsearch.vo.FlickrPhoto

@BindingAdapter("items")
fun setItems(listView: RecyclerView, items: List<FlickrPhoto>) {
    (listView.adapter as FlickrPhotosAdapter).submitList(items)
}
