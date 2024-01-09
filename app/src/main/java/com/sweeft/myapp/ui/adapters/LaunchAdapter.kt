package com.sweeft.myapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sweeft.myapp.data.Launch
import com.sweeft.myapp.databinding.LaunchItemBinding
import com.sweeft.myapp.ui.utills.LaunchesDiffCallBack

class LaunchAdapter:ListAdapter<Launch,LaunchViewHolder>(LaunchesDiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LaunchItemBinding.inflate(inflater, parent, false)
        return LaunchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


}
