package eu.innosoft.androidpoc.features.feed_list.adapter.delegate

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.commons.ViewTypeDelegateAdapter
import eu.innosoft.androidpoc.commons.extensions.inflate
import eu.innosoft.androidpoc.features.feed_list.adapter.FeedViewType

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: FeedViewType) {
    }


    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.feeds_item_loading))

}
