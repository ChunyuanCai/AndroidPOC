package eu.innosoft.androidpoc.features.feed_list.adapter.delegate

import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.commons.ViewTypeDelegateAdapter
import eu.innosoft.androidpoc.commons.extensions.inflate
import eu.innosoft.androidpoc.features.feed_detail.FeedDetailView
import eu.innosoft.androidpoc.features.feed_list.adapter.FeedViewType
import eu.innosoft.androidpoc.features.feed_list.models.Feed
import kotlinx.android.synthetic.main.feeds_item_feed.view.*

class FeedDelegateAdapter(val supportFragmentManager: FragmentManager?) : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: FeedViewType) {
        holder as TurnsViewHolder
        holder.bind(item as Feed, supportFragmentManager)
    }


    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.feeds_item_feed)) {

        fun bind(item: Feed, supportFragmentManager: FragmentManager?) = with(itemView) {
            tvMessage.text = item.message
            tvMessage.setOnClickListener {

                // as you can see how bad the fm being passing down from fragment to the delegate adapter
                // DI of dagger might simplify it by introducing a scope graph tho
                supportFragmentManager?.let {
                    it.beginTransaction()
                            .replace(R.id.vContainer, FeedDetailView())
                            .commit()
                }
            }
        }
    }

}
