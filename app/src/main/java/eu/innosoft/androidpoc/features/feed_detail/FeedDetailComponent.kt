package eu.innosoft.androidpoc.features.feed_detail

import dagger.Component
import eu.innosoft.androidpoc.activities.app_main.MainViewComponent
import eu.innosoft.androidpoc.di.FeatureScope

@Component(dependencies = [(MainViewComponent::class)], modules = [(FeedDetailModule::class)])
@FeatureScope
interface FeedDetailComponent {

    fun inject(view: FeedDetailView)


}