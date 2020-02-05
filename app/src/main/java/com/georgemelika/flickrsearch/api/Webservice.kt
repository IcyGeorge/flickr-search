package com.georgemelika.flickrsearch.api

import com.georgemelika.flickrsearch.api.response.PhotosResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    companion object {
        const val BASE_URL = "https://www.flickr.com/services/rest/"
    }

    @GET
    fun searchPhotos(
        @Query("text") text: String
    ): Single<PhotosResponse>
}