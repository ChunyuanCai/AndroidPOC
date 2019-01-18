package eu.innosoft.androidpoc.usecases

import eu.innosoft.androidpoc.data.models.FeedModel
import io.reactivex.Single
import io.reactivex.Single.just
import javax.inject.Inject

interface GetFeeds {

    fun call(): Single<List<FeedModel>>
}

class GetFeedsImpl @Inject internal constructor() : GetFeeds {
    // in real context, your repository is injected here as a data provider

    override fun call(): Single<List<FeedModel>> =
            just(listOf(
                    FeedModel(message = "Good news 00", author = "Cai"),
                    FeedModel(message = "Good news 01", author = "Chunyuan"),
                    FeedModel(message = "Good news 02", author = "Shu"),
                    FeedModel(message = "Good news 03", author = "Cai"),
                    FeedModel(message = "Good news 04", author = "Cai"),
                    FeedModel(message = "Good news 05", author = "Chunyuan"),
                    FeedModel(message = "Good news 06", author = "Shu"),
                    FeedModel(message = "Good news 07", author = "Zou")
            ))

}
