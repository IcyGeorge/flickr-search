package com.georgemelika.flickrsearch.vo

import android.util.Log
import com.google.gson.annotations.SerializedName

data class FlickrPhoto(
    @SerializedName("id")
    var id: String,
    @SerializedName("owner")
    var owner: String?,
    @SerializedName("secret")
    var secret: String,
    @SerializedName("server")
    var server: String,
    @SerializedName("farm")
    var farm: Int,
    @SerializedName("title")
    var title: String?,
    @SerializedName("ispublic")
    var isPublic: Int,
    @SerializedName("isfriend")
    var isFriend: Int,
    @SerializedName("isfamily")
    var isFamily: Int,
    @SerializedName("url_o")
    var imageUrlOriginal: String?
) {
    fun imageUrl(): String {
        return "https://farm$farm.static.flickr.com/$server/${id}_$secret.jpg"
    }
}