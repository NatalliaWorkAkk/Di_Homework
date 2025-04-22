package com.effectivemobile.faeture_home.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.effectivemobile.core.di.DaggerNetworkComponent
import com.effectivemobile.faeture_home.R
import com.effectivemobile.faeture_home.di.DaggerHomeComponent
import com.effectivemobile.faeture_home.di.HomeComponent
import com.effectivemobile.faeture_home.presentation.HomeViewModel.HomeViewModelProvider
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : Fragment() {

    private val homeComponent: HomeComponent by lazy {
        DaggerHomeComponent.builder()
            .networkDeps(DaggerNetworkComponent.create()).build()
    }

    @Inject
    lateinit var viewModelFactory: HomeViewModelProvider

    val viewModel: HomeViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        homeComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.networkResult.collect { result ->
                    Log.d("AAA", "$result")
                }
            }
        }
    }
}