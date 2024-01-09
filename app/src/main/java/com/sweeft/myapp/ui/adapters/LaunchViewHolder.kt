package com.sweeft.myapp.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.sweeft.myapp.data.Launch
import com.sweeft.myapp.databinding.LaunchItemBinding

class LaunchViewHolder(private val binding: LaunchItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Launch) {
        // Bind your data to the ViewHolder
        binding.txtMissionName.text=item.missionName
        binding.txtLaunchYear.text= item.launchYear.toString()
        binding.txtMissionID.text=item.missionID

    }
}



