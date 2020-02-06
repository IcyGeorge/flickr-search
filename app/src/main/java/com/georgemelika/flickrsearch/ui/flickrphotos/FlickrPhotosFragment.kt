package com.georgemelika.flickrsearch.ui.flickrphotos

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.georgemelika.flickrsearch.EventObserver
import com.georgemelika.flickrsearch.R
import com.georgemelika.flickrsearch.base.BaseFragment
import com.georgemelika.flickrsearch.databinding.FragmentFlickrPhotosBinding
import com.georgemelika.flickrsearch.vo.FlickrPhoto

class FlickrPhotosFragment : BaseFragment() {

    private val viewModel by viewModels<FlickrPhotosViewModel> { viewModelFactory }

    private lateinit var viewDataBinding: FragmentFlickrPhotosBinding

    private lateinit var listAdapter: FlickrPhotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentFlickrPhotosBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
        }
        setHasOptionsMenu(true)
        return viewDataBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_flickr_photos, menu)

        val searchManager = context!!.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(activity!!.componentName))
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    viewModel.searchFor(query)
                    dismissKeyboard(windowToken)
                    return true
                }

                override fun onQueryTextChange(query: String): Boolean {
                    return true
                }
            })
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setupListAdapter()
        setupNavigation()
    }

    private fun setupListAdapter() {
        val viewModel = viewDataBinding.viewmodel ?: return
        listAdapter = FlickrPhotosAdapter(viewModel)
        viewDataBinding.list.adapter = listAdapter
    }

    private fun setupNavigation() {
        viewModel.openPhotoEvent.observe(viewLifecycleOwner, EventObserver {
            openPhotoDetail(it)
        })
    }

    private fun openPhotoDetail(flickrPhoto: FlickrPhoto) {
        val action = FlickrPhotosFragmentDirections.showFlickrPhotoDetail(
            flickrPhoto.title ?: "",
            flickrPhoto.imageUrlOriginal ?: flickrPhoto.imageUrl()
        )
        findNavController().navigate(action)
    }
}