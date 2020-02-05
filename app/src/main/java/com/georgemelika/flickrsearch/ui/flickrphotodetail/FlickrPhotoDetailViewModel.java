package com.georgemelika.flickrsearch.ui.flickrphotodetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class FlickrPhotoDetailViewModel extends ViewModel {

    @Inject
    public FlickrPhotoDetailViewModel() {

    }

    private MutableLiveData<String> title = new MutableLiveData<>();
    private MutableLiveData<String> imageUrl = new MutableLiveData<>();

    public void start(String title, String imageUrl) {
        this.title.setValue(title);
        this.imageUrl.setValue(imageUrl);
    }

    public LiveData<String> getTitle() {
        return title;
    }

    public LiveData<String> getImageUrl() {
        return imageUrl;
    }
}
