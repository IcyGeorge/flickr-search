package com.georgemelika.flickrsearch.ui.flickrphotos

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.georgemelika.flickrsearch.*
import com.georgemelika.flickrsearch.repository.FlickrRepository
import com.georgemelika.flickrsearch.vo.Result.Error
import com.georgemelika.flickrsearch.vo.Result.Success
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.net.UnknownHostException

@ExperimentalCoroutinesApi
class FlickrPhotosViewModelTest {

    private lateinit var viewModel: FlickrPhotosViewModel

    private var flickrRepository: FlickrRepository = mock()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        viewModel = FlickrPhotosViewModel(flickrRepository)
    }

    @Test
    fun loadFlickrPhotosFromRepositoryAndLoadIntoView() {
        runBlocking {
            mainCoroutineRule.pauseDispatcher()

            whenever(flickrRepository.searchFlickrPhotos(SUCCESS_QUERY)).thenReturn(
                Success(SUCCESS_QUERY_LIST)
            )

            viewModel.searchFor(SUCCESS_QUERY)
            assertTrue(LiveDataTestUtil.getValue(viewModel.dataLoading))

            mainCoroutineRule.resumeDispatcher()

            assertFalse(LiveDataTestUtil.getValue(viewModel.dataLoading))
            assertFalse(LiveDataTestUtil.getValue(viewModel.isDataLoadingError))
            assertEquals(LiveDataTestUtil.getValue(viewModel.items).size, SUCCESS_QUERY_LIST.size)
        }
    }

    @Test
    fun loadFlickrPhotos_emptyResponseError() {
        runBlocking {
            mainCoroutineRule.pauseDispatcher()

            whenever(flickrRepository.searchFlickrPhotos(FAILED_QUERY)).thenReturn(
                Success(FAILED_QUERY_LIST)
            )

            viewModel.searchFor(FAILED_QUERY)
            assertTrue(LiveDataTestUtil.getValue(viewModel.dataLoading))

            mainCoroutineRule.resumeDispatcher()

            assertFalse(LiveDataTestUtil.getValue(viewModel.dataLoading))
            assertFalse(LiveDataTestUtil.getValue(viewModel.isDataLoadingError))
            assertEquals(LiveDataTestUtil.getValue(viewModel.items).size, FAILED_QUERY_LIST.size)
        }
    }

    @Test
    fun loadFlickrPhotos_noInternetError() {
        runBlocking {
            mainCoroutineRule.pauseDispatcher()

            whenever(flickrRepository.searchFlickrPhotos(FAILED_QUERY)).thenReturn(
                Error(UnknownHostException("flickr.com"))
            )

            viewModel.searchFor(FAILED_QUERY)
            assertTrue(LiveDataTestUtil.getValue(viewModel.dataLoading))

            mainCoroutineRule.resumeDispatcher()

            assertFalse(LiveDataTestUtil.getValue(viewModel.dataLoading))
            assertTrue(LiveDataTestUtil.getValue(viewModel.isDataLoadingError))
            assertEquals(LiveDataTestUtil.getValue(viewModel.items).size, FAILED_QUERY_LIST.size)
        }
    }
}