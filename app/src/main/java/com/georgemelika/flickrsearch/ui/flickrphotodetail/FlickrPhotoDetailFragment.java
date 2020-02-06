package com.georgemelika.flickrsearch.ui.flickrphotodetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.georgemelika.flickrsearch.base.BaseFragment;
import com.georgemelika.flickrsearch.databinding.FragmentFlickrPhotoDetailBinding;

public class FlickrPhotoDetailFragment extends BaseFragment {

    private FragmentFlickrPhotoDetailBinding viewDataBinding;
    private FlickrPhotoDetailViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewDataBinding = FragmentFlickrPhotoDetailBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(FlickrPhotoDetailViewModel.class);

        viewDataBinding.setLifecycleOwner(getViewLifecycleOwner());
        viewDataBinding.setViewmodel(viewModel);

        setHasOptionsMenu(true);

        setupDetail();

        return viewDataBinding.getRoot();
    }

    private void setupDetail() {
        String title = FlickrPhotoDetailFragmentArgs.fromBundle(getArguments()).getTitle();
        String imageUrl = FlickrPhotoDetailFragmentArgs.fromBundle(getArguments()).getImageUrl();
        viewModel.start(title, imageUrl);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
    }
}
