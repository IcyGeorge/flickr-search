package com.georgemelika.flickrsearch.di

import androidx.lifecycle.ViewModel
import com.georgemelika.flickrsearch.ui.flickrphotodetail.FlickrPhotoDetailFragment
import com.georgemelika.flickrsearch.ui.flickrphotodetail.FlickrPhotoDetailViewModel
import com.georgemelika.flickrsearch.ui.flickrphotos.FlickrPhotosFragment
import com.georgemelika.flickrsearch.ui.flickrphotos.FlickrPhotosViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class FlickrPhotoDetailModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun flickrPhotoDetailFragment(): FlickrPhotoDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(FlickrPhotoDetailViewModel::class)
    abstract fun bindViewModel(viewModel: FlickrPhotoDetailViewModel): ViewModel
}
