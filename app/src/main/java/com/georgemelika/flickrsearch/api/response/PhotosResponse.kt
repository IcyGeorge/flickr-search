package com.georgemelika.flickrsearch.api.response

import com.georgemelika.flickrsearch.vo.FlickrPhoto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class PhotosResponse(
    @SerializedName("photos")
    @Expose
    var photos: List<FlickrPhoto>?
)
