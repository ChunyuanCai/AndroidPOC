package eu.innosoft.androidpoc.features.feed_list

import eu.innosoft.androidpoc.features.feed_list.adapter.FeedViewType
import eu.innosoft.androidpoc.features.feed_list.models.Ad
import eu.innosoft.androidpoc.features.feed_list.models.Feed
import eu.innosoft.androidpoc.usecases.GetAds
import eu.innosoft.androidpoc.usecases.GetFeeds
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class FeedListViewModel constructor(
        private var getFeeds: GetFeeds,
        private var getAds: GetAds) {

    fun getDataForFeedList(): Single<List<FeedViewType>> =
            getFeeds.call().zipWith(getAds.call(), BiFunction { feeds, ads ->

                val resultList: MutableList<FeedViewType> = ArrayList()
                feeds.forEach { resultList.add(Feed(it.message, it.author, it.vote)) }
                ads.forEach { resultList.add(it.position, Ad(it.message)) }
                resultList
            })


}