package eu.innosoft.androidpoc.data.repository

import eu.innosoft.androidpoc.data.api.Api
import eu.innosoft.androidpoc.data.models.FeedModel
import io.reactivex.Single
import javax.inject.Inject

interface FeedsRepository {

    fun get(): Single<List<FeedModel>>
}

class FeedRepositoryImpl @Inject internal constructor(val api: Api) : FeedsRepository {
    override fun get(): Single<List<FeedModel>> =
            api.getFeeds()

}