package eu.innosoft.androidpoc.features.feed_list.adapter.delegate

import android.view.ViewGroup
import androidx.navigation.navOptions
import androidx.recyclerview.widget.RecyclerView
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.commons.ViewTypeDelegateAdapter
import eu.innosoft.androidpoc.commons.extensions.findNavController
import eu.innosoft.androidpoc.commons.extensions.inflate
import eu.innosoft.androidpoc.features.feed_list.adapter.FeedViewType
import eu.innosoft.androidpoc.features.feed_list.models.Feed
import kotlinx.android.synthetic.main.feeds_item_feed.view.*

class FeedDelegateAdapter : ViewTypeDelegateAdapter {


    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: FeedViewType) {
        holder as TurnsViewHolder
        holder.bind(item as Feed)
    }


    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.feeds_item_feed)) {

        fun bind(item: Feed) = with(itemView) {
            tvMessage.text = item.message
            tvMessage.setOnClickListener { v ->
                v.findNavController().navigate(
                        R.id.action_feedListView_to_feedDetailView,
                        null,
                        navOptions {
                            anim {
                                enter = R.anim.slide_in_right
                                exit = R.anim.slide_out_left
                                popEnter = R.anim.slide_in_left
                                popExit = R.anim.slide_out_right
                            }
                        })
            }
        }
    }

}
