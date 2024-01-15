package com.sweeft.launchesapp.utills

import androidx.recyclerview.widget.DiffUtil
import com.sweeft.launchesapp.domain.model.Launch

class LaunchesDiffCallBack: DiffUtil.ItemCallback<Launch>(){

    override fun areItemsTheSame(oldItem: Launch, newItem: Launch): Boolean {
        return oldItem.missionName == newItem.missionName
    }

    override fun areContentsTheSame(oldItem: Launch, newItem: Launch): Boolean {
        return oldItem == newItem
    }
}