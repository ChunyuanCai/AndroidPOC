package eu.innosoft.androidpoc.features.feed_list.adapter

interface FeedViewType {

    fun getViewType(): Int

    object FeedListTypeConst {

        val FEED = 1
        val LOADING = 2
        val AD = 3

    }

}