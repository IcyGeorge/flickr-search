package com.georgemelika.flickrsearch.di

import androidx.lifecycle.ViewModel
import com.georgemelika.flickrsearch.ui.flickrphotos.FlickrPhotosFragment
import com.georgemelika.flickrsearch.ui.flickrphotos.FlickrPhotosViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class FlickrPhotosModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelBuilder::class
        ]
    )
    internal abstract fun flickrPhotosFragment(): FlickrPhotosFragment

    @Binds
    @IntoMap
    @ViewModelKey(FlickrPhotosViewModel::class)
    abstract fun bindViewModel(viewModel: FlickrPhotosViewModel): ViewModel
}
