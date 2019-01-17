package eu.innosoft.androidpoc.features.feed_list

import dagger.Component
import eu.innosoft.androidpoc.activities.app_main.MainViewComponent
import eu.innosoft.androidpoc.di.FeatureScope

@Component(dependencies = [(MainViewComponent::class)], modules = [(FeedListModule::class)])
@FeatureScope
interface FeedListComponent {
    fun inject(view: FeedListView)
}