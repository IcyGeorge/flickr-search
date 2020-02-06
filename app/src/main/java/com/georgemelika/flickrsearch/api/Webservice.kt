package com.georgemelika.flickrsearch.api

import com.georgemelika.flickrsearch.BuildConfig
import com.georgemelika.flickrsearch.api.response.ListingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    companion object {
        const val BASE_URL = "https://www.flickr.com"
    }

    @GET("/services/rest")
    suspend fun searchFlickrPhotos(
        @Query("method") method: String = "flickr.photos.search",
        @Query("api_key") apiKey: String = BuildConfig.FLICKR_API_KEY,
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallback: Int = 1,
        @Query("per_page") perPage: Int = 25,
        @Query("extras") extras: String = "url_o",
        @Query("text") query: String
    ): ListingResponse
}