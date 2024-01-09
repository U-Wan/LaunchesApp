package com.sweeft.myapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.sweeft.myapp.R
import com.sweeft.myapp.data.Launch
import com.sweeft.myapp.ui.adapters.LaunchAdapter
import com.sweeft.myapp.ui.viewmodel.LaunchesViewModel

class LaunchesFragment : Fragment(R.layout.fragment_launches) {

    private lateinit var viewModel: LaunchesViewModel
    private lateinit var recyclerViewAdapter: LaunchAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up ViewModel and RecyclerViewAdapter
        viewModel = ViewModelProvider(this).get(LaunchesViewModel::class.java)
        recyclerViewAdapter = LaunchAdapter()

        // Set up RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = recyclerViewAdapter

        // Observe the LiveData and update the RecyclerView when the data changes
        viewModel.dataList.observe(viewLifecycleOwner) { newDataList ->
            recyclerViewAdapter.submitList(newDataList)
        }

        // Example: Add item to the list
        val newItem = Launch("New Mission", "new_id", 2023)
        viewModel.addItem(newItem)
    }
}
