package eu.innosoft.androidpoc.usecases

import eu.innosoft.androidpoc.data.models.FeedModel
import eu.innosoft.androidpoc.data.repository.FeedsRepository
import io.reactivex.Single
import javax.inject.Inject

interface GetFeeds {

    fun call(): Single<List<FeedModel>>
}

class GetFeedsImpl @Inject internal constructor(private var repository: FeedsRepository) : GetFeeds {

    override fun call(): Single<List<FeedModel>> =
            repository.get()

}
