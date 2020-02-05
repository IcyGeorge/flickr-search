package com.georgemelika.flickrsearch.ui.flickrphotos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.georgemelika.flickrsearch.databinding.ItemFlickrPhotoBinding
import com.georgemelika.flickrsearch.ui.flickrphotos.FlickrPhotosAdapter.ViewHolder
import com.georgemelika.flickrsearch.vo.FlickrPhoto

class FlickrPhotosAdapter(private val viewModel: FlickrPhotosViewModel) :
    ListAdapter<FlickrPhoto, ViewHolder>(TaskDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(viewModel, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ItemFlickrPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: FlickrPhotosViewModel, item: FlickrPhoto) {
            binding.viewmodel = viewModel
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFlickrPhotoBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class TaskDiffCallback : DiffUtil.ItemCallback<FlickrPhoto>() {
    override fun areItemsTheSame(oldItem: FlickrPhoto, newItem: FlickrPhoto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FlickrPhoto, newItem: FlickrPhoto): Boolean {
        return oldItem == newItem
    }
}
