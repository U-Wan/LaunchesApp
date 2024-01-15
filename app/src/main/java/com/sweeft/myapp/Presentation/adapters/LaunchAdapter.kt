package com.sweeft.myapp.Presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.sweeft.myapp.domain.Launch
import com.sweeft.myapp.databinding.LaunchItemBinding
import com.sweeft.myapp.utills.LaunchesDiffCallBack

class LaunchAdapter : PagingDataAdapter<Launch, LaunchViewHolder>(LaunchesDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LaunchItemBinding.inflate(inflater, parent, false)
        return LaunchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }
    }
}
