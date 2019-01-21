package eu.innosoft.androidpoc

import android.content.Context
import android.content.res.Resources
import dagger.Component
import eu.innosoft.androidpoc.data.api.ApiModule
import eu.innosoft.androidpoc.data.repository.AdsRepository
import eu.innosoft.androidpoc.data.repository.FeedsRepository
import eu.innosoft.androidpoc.data.repository.RepositoryModule
import java.util.*
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepositoryModule::class, ApiModule::class])
interface AppComponent {

    fun inject(app: App)
    fun exposeAppContext(): Context
    fun exposeResources(): Resources
    fun exposeLocale(): Locale


    fun exposeFeedsRepository(): FeedsRepository
    fun exposeAdsRepository(): AdsRepository
}