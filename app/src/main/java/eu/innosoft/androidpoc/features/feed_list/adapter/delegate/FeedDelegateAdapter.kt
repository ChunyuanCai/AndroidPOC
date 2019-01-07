package eu.innosoft.androidpoc.features.feed_list.adapter.delegate

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import androidx.navigation.NavController
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.commons.ViewTypeDelegateAdapter
import eu.innosoft.androidpoc.commons.extensions.inflate
import eu.innosoft.androidpoc.features.feed_list.adapter.FeedViewType
import eu.innosoft.androidpoc.features.feed_list.models.Feed
import kotlinx.android.synthetic.main.feeds_item_feed.view.*

class FeedDelegateAdapter(val navigator: NavController) : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: FeedViewType) {
        holder as TurnsViewHolder
        holder.bind(item as Feed, navigator)
    }


    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.feeds_item_feed)) {

        fun bind(item: Feed, navigator: NavController) = with(itemView) {
            tvMessage.text = item.message
            tvMessage.setOnClickListener {
                navigator.navigate(R.id.action_feedListView_to_feedDetailView)
            }
        }
    }

}
