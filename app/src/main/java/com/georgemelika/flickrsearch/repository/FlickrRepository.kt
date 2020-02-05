package com.georgemelika.flickrsearch.repository

import com.georgemelika.flickrsearch.api.WebService
import javax.inject.Inject
import javax.inject.Singleton

class FlickrRepository @Inject constructor(
    private val webService: WebService
)