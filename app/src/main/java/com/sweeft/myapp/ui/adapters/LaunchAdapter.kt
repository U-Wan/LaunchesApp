package com.sweeft.myapp.ui.adapters

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sweeft.myapp.data.Launch
import com.sweeft.myapp.ui.utills.LaunchesDiffCallBack

class LaunchAdapter(private val context: Context):
   ListAdapter<Launch,LaunchViewHolder>(LaunchesDiffCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
