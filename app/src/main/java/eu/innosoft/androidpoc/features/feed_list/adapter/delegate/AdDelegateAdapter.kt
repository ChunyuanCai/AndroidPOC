package eu.innosoft.androidpoc.features.feed_list.adapter.delegate

import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.commons.ViewTypeDelegateAdapter
import eu.innosoft.androidpoc.commons.extensions.inflate
import eu.innosoft.androidpoc.features.ad_detail.AdDetailView
import eu.innosoft.androidpoc.features.feed_list.adapter.FeedViewType
import eu.innosoft.androidpoc.features.feed_list.models.Ad
import kotlinx.android.synthetic.main.feeds_item_ad.view.*

class AdDelegateAdapter(val fm: FragmentManager?) : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent, fm)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: FeedViewType) {
        holder as TurnsViewHolder
        holder.bind(item as Ad)
    }


    class TurnsViewHolder(val parent: ViewGroup, private val fm: FragmentManager?) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.feeds_item_ad)) {

        fun bind(item: Ad) = with(itemView) {
            tvAd.text = item.adMessage
            tvAd.setOnClickListener {
                fm?.beginTransaction()
                        ?.replace(R.id.nav_host_fragment, AdDetailView())
                        ?.commit()
            }
        }
    }

}
