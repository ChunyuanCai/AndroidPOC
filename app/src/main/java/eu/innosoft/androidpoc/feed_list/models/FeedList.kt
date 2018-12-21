package eu.innosoft.androidpoc.feed_list.models

import eu.innosoft.androidpoc.feed_list.adapter.FeedViewType

data class Feed(val message: String, val author: String = "Cai", val vote: Int = 0) : FeedViewType {
    override fun getViewType(): Int = FeedViewType.FeedListTypeConst.FEED
}

data class Ad(val adMessage: String) : FeedViewType {
    override fun getViewType(): Int = FeedViewType.FeedListTypeConst.AD

}