package com.sweeft.myapp.ui.utills

import androidx.recyclerview.widget.DiffUtil
import com.sweeft.myapp.data.Launch

class LaunchesDiffCallBack: DiffUtil.ItemCallback<Launch>() {

    override fun areItemsTheSame(oldItem: Launch, newItem: Launch): Boolean {
        return oldItem.missionID == newItem.missionID
    }

    override fun areContentsTheSame(oldItem: Launch, newItem: Launch): Boolean {
        return oldItem == newItem
    }
}