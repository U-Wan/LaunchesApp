package com.sweeft.launchesapp.Presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.sweeft.launchesapp.Presentation.adapters.LaunchAdapter
import com.sweeft.launchesapp.Presentation.viewmodel.LaunchesViewModel
import com.sweeft.launchesapp.R
import com.sweeft.launchesapp.databinding.FragmentLaunchesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LaunchesFragment : Fragment(R.layout.fragment_launches) {

    private val viewModel: LaunchesViewModel by viewModels()
    private lateinit var recyclerViewAdapter: LaunchAdapter
    private lateinit var binding: FragmentLaunchesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLaunchesBinding.bind(view)

        recyclerViewAdapter = LaunchAdapter()
        binding.recyclerView.adapter = recyclerViewAdapter

        viewModel.fetchData()

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listData.collectLatest { newDataList ->
                    recyclerViewAdapter.submitData(newDataList)
                }
            }
        }

    }
}
