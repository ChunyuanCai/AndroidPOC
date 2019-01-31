package eu.innosoft.androidpoc

import dagger.Component
import eu.innosoft.androidpoc.data.api.MockApiModule
import eu.innosoft.androidpoc.data.repository.RepositoryModule
import eu.innosoft.androidpoc.feature.feed_list.FeedListGreenCoffeeTest
import eu.innosoft.androidpoc.feature.feed_list.FeedListTest
import eu.innosoft.androidpoc.feature.sign_up.SignUpTest
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    RepositoryModule::class,
    MockApiModule::class])

interface MockAppComponent : AppComponent {
    fun inject(feedListTest: FeedListTest)
    fun inject(signUpTest: SignUpTest)
    fun inject(feedListGreenCoffeeTest: FeedListGreenCoffeeTest)
}