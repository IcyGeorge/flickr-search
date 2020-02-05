package com.georgemelika.flickrsearch.ui.flickrphotos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georgemelika.flickrsearch.Event
import com.georgemelika.flickrsearch.R
import com.georgemelika.flickrsearch.repository.FlickrRepository
import com.georgemelika.flickrsearch.vo.FlickrPhoto
import com.georgemelika.flickrsearch.vo.Result
import com.georgemelika.flickrsearch.vo.Result.Success
import kotlinx.coroutines.launch
import java.util.ArrayList
import javax.inject.Inject

class FlickrPhotosViewModel @Inject constructor(private val repository: FlickrRepository) :
    ViewModel() {


    private val _items = MutableLiveData<List<FlickrPhoto>>().apply { value = emptyList() }
    val items: LiveData<List<FlickrPhoto>> = _items

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _noPhotosLabel = MutableLiveData<Int>()
    val noPhotosLabel: LiveData<Int> = _noPhotosLabel

    private val _openPhotoEvent = MutableLiveData<Event<FlickrPhoto>>()
    val openPhotoEvent: LiveData<Event<FlickrPhoto>> = _openPhotoEvent

    fun searchFor(query: String) {
        _dataLoading.value = true
        viewModelScope.launch {
            val result = repository.searchFlickrPhotos(query)
            if (result is Success) {
                val photos = result.data
                _items.value = ArrayList(photos)
            } else {
                _items.value = emptyList()
            }
            _dataLoading.value = false
        }
    }

    fun clearResults() {

    }

    fun openFlickrPhoto(item: FlickrPhoto) {
        _openPhotoEvent.value = Event(item)
    }
}