package com.sweeft.launchesapp.Presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sweeft.launchesapp.R
import com.sweeft.launchesapp.databinding.LaunchItemBinding
import com.sweeft.launchesapp.domain.model.Launch

class LaunchViewHolder(private val binding: LaunchItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Launch) {
        binding.tvMissionName.text = "Mission Name: ${item.missionName}"
        binding.tvLaunchYear.text = "Launch Year: ${item.launchYear}"
        binding.tvRocketName.text = "Rocket Name: ${item.rocket?.rocketName}"


        val firstImage = item.links?.flickrImages?.firstOrNull()
        if (!firstImage.isNullOrBlank()) {
            Glide.with(binding.root.context)
                .load(firstImage)
                .placeholder(R.drawable.no_photo)
                .into(binding.rocketImg)
        } else {
            Glide.with(binding.root.context)
                .load(R.drawable.no_photo)
                .placeholder(R.drawable.no_photo)
                .into(binding.rocketImg)
        }
    }

}



