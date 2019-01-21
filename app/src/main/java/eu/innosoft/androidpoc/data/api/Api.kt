package eu.innosoft.androidpoc.data.api

import eu.innosoft.androidpoc.data.models.AdModel
import eu.innosoft.androidpoc.data.models.FeedModel

import io.reactivex.Single

interface Api {

    fun getFeeds(): Single<List<FeedModel>>

    fun getAds(): Single<List<AdModel>>
}

class ApiServiceImpl : Api {
    override fun getFeeds(): Single<List<FeedModel>> =
            Single.just(listOf(
                    FeedModel(message = "Good news 00", author = "Cai"),
                    FeedModel(message = "Good news 01", author = "Chunyuan"),
                    FeedModel(message = "Good news 02", author = "Shu"),
                    FeedModel(message = "Good news 03", author = "Cai"),
                    FeedModel(message = "Good news 04", author = "Cai"),
                    FeedModel(message = "Good news 05", author = "Chunyuan"),
                    FeedModel(message = "Good news 06", author = "Shu"),
                    FeedModel(message = "Good news 07", author = "Zixuan"),
                    FeedModel(message = "Good news 08", author = "Zou"),
                    FeedModel(message = "Good news 09", author = "Cai")

            ))

    override fun getAds(): Single<List<AdModel>> =
            Single.just(listOf(
                    AdModel(message = "Ad 0", position = 1),
                    AdModel(message = "Ad 1", position = 3),
                    AdModel(message = "Ad 2", position = 7)))

}