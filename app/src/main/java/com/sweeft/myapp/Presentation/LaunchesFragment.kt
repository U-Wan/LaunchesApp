package com.sweeft.myapp.Presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.sweeft.myapp.R
import com.sweeft.myapp.Presentation.adapters.LaunchAdapter
import com.sweeft.myapp.Presentation.viewmodel.LaunchesViewModel
import com.sweeft.myapp.Presentation.viewmodel.LaunchesViewModelFactory
import com.sweeft.myapp.data.ApiService
import com.sweeft.myapp.data.LaunchRepository

class LaunchesFragment : Fragment(R.layout.fragment_launches) {

    private lateinit var viewModel: LaunchesViewModel
    private lateinit var recyclerViewAdapter: LaunchAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = LaunchRepository(ApiService.create())
        val factory = LaunchesViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(LaunchesViewModel::class.java)

        recyclerViewAdapter = LaunchAdapter()

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = recyclerViewAdapter

        viewModel.dataList.observe(viewLifecycleOwner) { newDataList ->
            recyclerViewAdapter.submitList(newDataList)
        }

        viewModel.fetchData()
    }
}
