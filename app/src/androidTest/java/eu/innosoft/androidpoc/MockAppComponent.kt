package eu.innosoft.androidpoc

import dagger.Component
import eu.innosoft.androidpoc.data.api.MockApiModule
import eu.innosoft.androidpoc.data.repository.RepositoryModule
import eu.innosoft.androidpoc.feature.feed_list.FeedListTest
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    RepositoryModule::class,
    MockApiModule::class])

interface MockAppComponent : AppComponent {
    fun inject(feedListTest: FeedListTest)
}