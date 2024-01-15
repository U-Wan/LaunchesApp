package com.sweeft.myapp.Presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sweeft.myapp.R
import com.sweeft.myapp.domain.Launch
import com.sweeft.myapp.databinding.LaunchItemBinding

class LaunchViewHolder(private val binding: LaunchItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Launch) {
        binding.tvMissionName.text = "Mission Name: ${item.missionName}"
        binding.tvLaunchYear.text = "Launch Year: ${item.launchYear}"
        binding.tvRocketName.text = "Rocket Name: ${item.rocket?.rocketName}"
        binding.tvDetails.text = "Details: ${item.details}"

        val firstImage = item.links?.flickrImages?.firstOrNull()
        if (!firstImage.isNullOrBlank()) {
            Glide.with(binding.root.context)
                .load(firstImage)
                .placeholder(R.drawable.starship)
                .into(binding.rocketImg)
        } else {
            Glide.with(binding.root.context)
                .load(R.drawable.starship)
                .placeholder(R.drawable.starship)
                .into(binding.rocketImg)
        }
    }

}



