package com.georgemelika.flickrsearch.base

import android.content.Context
import android.os.IBinder
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected fun dismissKeyboard(windowToken: IBinder?) {
        if (windowToken == null) return
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(windowToken, 0)
    }
}