package eu.innosoft.androidpoc.features.feed_list.adapter

import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import eu.innosoft.androidpoc.commons.ViewTypeDelegateAdapter
import eu.innosoft.androidpoc.features.feed_list.adapter.delegate.AdDelegateAdapter
import eu.innosoft.androidpoc.features.feed_list.adapter.delegate.FeedDelegateAdapter
import eu.innosoft.androidpoc.features.feed_list.adapter.delegate.LoadingDelegateAdapter
import java.util.*

class FeedsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<FeedViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : FeedViewType {
        override fun getViewType() = FeedViewType.FeedListTypeConst.LOADING
    }

    init {
        delegateAdapters.put(FeedViewType.FeedListTypeConst.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(FeedViewType.FeedListTypeConst.FEED, FeedDelegateAdapter())
        delegateAdapters.put(FeedViewType.FeedListTypeConst.AD, AdDelegateAdapter())
        items = ArrayList()
        items.add(loadingItem)
    }

    fun addFeeds(feeds: List<FeedViewType>) {
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)
        items.addAll(feeds)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)

    override fun getItemViewType(position: Int): Int = items[position].getViewType()

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))!!.onBindViewHolder(holder, this.items[position])
    }

}
