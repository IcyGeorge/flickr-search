package com.georgemelika.flickrsearch.vo

import com.google.gson.annotations.SerializedName

data class FlickrPhoto(
    @SerializedName("id")
    var id: Int,
    @SerializedName("owner")
    var owner: String?,
    @SerializedName("secret")
    var secret: String?,
    @SerializedName("server")
    var server: String,
    @SerializedName("farm")
    var farm: Int,
    @SerializedName("title")
    var title: String?,
    @SerializedName("ispublic")
    var isPublic: Boolean,
    @SerializedName("isfriend")
    var isFriend: Boolean,
    @SerializedName("isfamily")
    var isFamily: Boolean
) {
    val imageUrl: String by lazy {
        "http://farm$farm.static.flickr.com/$server/${id}_$secret.jpg"
    }
}