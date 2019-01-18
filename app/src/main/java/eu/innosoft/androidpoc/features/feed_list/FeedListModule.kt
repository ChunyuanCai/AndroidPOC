package eu.innosoft.androidpoc.features.feed_list

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import eu.innosoft.androidpoc.di.FeatureScope
import eu.innosoft.androidpoc.usecases.GetAds
import eu.innosoft.androidpoc.usecases.GetAdsImpl
import eu.innosoft.androidpoc.usecases.GetFeeds
import eu.innosoft.androidpoc.usecases.GetFeedsImpl


@Module
class FeedListModule(val view: FeedListView) {

    @Provides
    @FeatureScope
    fun provideGetFeeds(getFeeds: GetFeedsImpl): GetFeeds = getFeeds

    @Provides
    @FeatureScope
    fun provideGetAds(getAds: GetAdsImpl): GetAds = getAds

    @Provides
    @FeatureScope
    fun provideViewModelFactory(getFeeds: GetFeeds, getAds: GetAds): FeedListViewModelFactory = FeedListViewModelFactory(getFeeds, getAds)

    @Provides
    @FeatureScope
    fun provideViewModel(feedListViewModelFactory: FeedListViewModelFactory): FeedListViewModel =
            ViewModelProviders.of(view as Fragment, feedListViewModelFactory).get(FeedListViewModel::class.java)

}