package com.georgemelika.flickrsearch.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.georgemelika.flickrsearch.api.WebService
import com.georgemelika.flickrsearch.vo.FlickrPhoto
import com.georgemelika.flickrsearch.vo.Result
import com.georgemelika.flickrsearch.vo.Result.Error
import com.georgemelika.flickrsearch.vo.Result.Success
import javax.inject.Inject
import javax.inject.Singleton

class FlickrRepository @Inject constructor(
    private val webService: WebService
) {

    suspend fun searchFlickrPhotos(query: String): Result<List<FlickrPhoto>> {
        webService.searchFlickrPhotos(query = query).photos?.photos?.let {
            return Success(it)
        }

        return Error(Exception("photos not found"))
    }
}