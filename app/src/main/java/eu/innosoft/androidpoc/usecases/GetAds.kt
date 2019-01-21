package eu.innosoft.androidpoc.usecases

import eu.innosoft.androidpoc.data.models.AdModel
import eu.innosoft.androidpoc.data.repository.AdsRepository
import io.reactivex.Single
import javax.inject.Inject

interface GetAds {

    fun call(): Single<List<AdModel>>
}

class GetAdsImpl @Inject internal constructor(private val repository: AdsRepository) : GetAds {

    override fun call(): Single<List<AdModel>> =
            repository.get()

}
