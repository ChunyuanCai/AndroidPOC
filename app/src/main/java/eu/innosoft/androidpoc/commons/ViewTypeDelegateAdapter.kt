package eu.innosoft.androidpoc.commons

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import eu.innosoft.androidpoc.features.feed_list.adapter.FeedViewType

interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: FeedViewType)
}