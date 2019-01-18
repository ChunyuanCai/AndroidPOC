package eu.innosoft.androidpoc.usecases

import eu.innosoft.androidpoc.data.models.AdModel
import io.reactivex.Single
import io.reactivex.Single.just
import javax.inject.Inject

interface GetAds {

    fun call(): Single<List<AdModel>>
}

class GetAdsImpl @Inject internal constructor() : GetAds {
    // in real context, your repository is injected here as a data provider
    override fun call(): Single<List<AdModel>> =
            just(listOf(
                    AdModel(message = "Ad 0", position = 1),
                    AdModel(message = "Ad 1", position = 3)))

}
