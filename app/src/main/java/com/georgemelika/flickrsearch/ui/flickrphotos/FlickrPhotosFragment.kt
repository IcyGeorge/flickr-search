package com.georgemelika.flickrsearch.ui.flickrphotos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.georgemelika.flickrsearch.base.BaseFragment
import com.georgemelika.flickrsearch.databinding.FragmentFlickrPhotosBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FlickrPhotosFragment : BaseFragment() {

    private val viewModel by viewModels<FlickrPhotosViewModel> { viewModelFactory }

    private lateinit var viewDataBinding: FragmentFlickrPhotosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentFlickrPhotosBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
        }
        return viewDataBinding.root
    }
}