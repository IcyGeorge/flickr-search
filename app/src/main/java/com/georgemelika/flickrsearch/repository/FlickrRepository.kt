package com.georgemelika.flickrsearch.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.georgemelika.flickrsearch.api.WebService
import com.georgemelika.flickrsearch.vo.FlickrPhoto
import com.georgemelika.flickrsearch.vo.Result
import com.georgemelika.flickrsearch.vo.Result.Error
import com.georgemelika.flickrsearch.vo.Result.Success
import retrofit2.HttpException
import java.lang.Exception
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

class FlickrRepository @Inject constructor(
    private val webService: WebService
) {

    suspend fun searchFlickrPhotos(query: String): Result<List<FlickrPhoto>> {
        try {
            webService.searchFlickrPhotos(query = query).photos?.photos?.let {
                return if (it.isEmpty()) {
                    Error(Exception("No Photos found"))
                }else {
                    Success(it)
                }
            } ?: run {
                return Error(Exception("No Photos found"))
            }
        } catch (e: Exception) {
            return Error(e)
        }
    }
}