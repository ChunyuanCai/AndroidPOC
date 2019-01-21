package eu.innosoft.androidpoc.data.repository

import eu.innosoft.androidpoc.data.api.Api
import eu.innosoft.androidpoc.data.models.AdModel
import io.reactivex.Single
import javax.inject.Inject

interface AdsRepository {
    fun get(): Single<List<AdModel>>
}

class AdsPepositoryImpl @Inject internal constructor(val api: Api) : AdsRepository {
    override fun get(): Single<List<AdModel>> =
            api.getAds()

}