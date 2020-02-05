package com.georgemelika.flickrsearch.api.response

import com.georgemelika.flickrsearch.vo.FlickrPhoto
import com.google.gson.annotations.SerializedName

data class ListingResponse(
    @SerializedName("photos")
    var photos: PhotosResponse?
)

data class PhotosResponse(
    @SerializedName("page")
    var page: Int,
    @SerializedName("pages")
    var pages: Int,
    @SerializedName("perpage")
    var perPage: Int,
    @SerializedName("total")
    var total: String,
    @SerializedName("photo")
    var photos: List<FlickrPhoto>?
)