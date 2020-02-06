package com.georgemelika.flickrsearch

import com.georgemelika.flickrsearch.vo.FlickrPhoto

const val SUCCESS_QUERY: String = "success"
const val FAILED_QUERY: String = "fail"

val SUCCESS_QUERY_LIST: List<FlickrPhoto> = listOf(
    FlickrPhoto(
        "49496422142",
        "77903093@N00",
        "5f9c5d50fa",
        "65535",
        66,
        "200204 Shinjuku Gyoen-05.jpg",
        1,
        0,
        0,
        "https://live.staticflickr.com/65535/49496422142_dfed355d67_o.jpg"
    ),
    FlickrPhoto(
        "49496422142",
        "77903093@N00",
        "5f9c5d50fa",
        "65535",
        66,
        "200204 Shinjuku Gyoen-05.jpg",
        1,
        0,
        0,
        "https://live.staticflickr.com/65535/49496422142_dfed355d67_o.jpg"
    ),
    FlickrPhoto(
        "49496422142",
        "77903093@N00",
        "5f9c5d50fa",
        "65535",
        66,
        "200204 Shinjuku Gyoen-05.jpg",
        1,
        0,
        0,
        "https://live.staticflickr.com/65535/49496422142_dfed355d67_o.jpg"
    )
)

val FAILED_QUERY_LIST: List<FlickrPhoto> = emptyList()