package eu.innosoft.androidpoc.features.feed_list.adapter.delegate

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.commons.ViewTypeDelegateAdapter
import eu.innosoft.androidpoc.commons.extensions.inflate
import eu.innosoft.androidpoc.features.feed_list.adapter.FeedViewType
import eu.innosoft.androidpoc.features.feed_list.models.Ad
import kotlinx.android.synthetic.main.feeds_item_ad.view.*

class AdDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: FeedViewType) {
        holder as TurnsViewHolder
        holder.bind(item as Ad)
    }


    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.feeds_item_ad)) {

        fun bind(item: Ad) = with(itemView) {
            tvAd.text = item.adMessage
        }
    }

}
