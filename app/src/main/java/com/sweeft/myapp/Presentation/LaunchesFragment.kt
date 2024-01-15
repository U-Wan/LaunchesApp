package com.sweeft.myapp.Presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sweeft.myapp.Presentation.adapters.LaunchAdapter
import com.sweeft.myapp.Presentation.viewmodel.LaunchesViewModel
import com.sweeft.myapp.R
import com.sweeft.myapp.databinding.FragmentLaunchesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

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

        // Call fetchData() when the fragment is created
        viewModel.fetchData()

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.listData.collectLatest { newDataList ->
                recyclerViewAdapter.submitData(newDataList)
            }
        }
    }
}
