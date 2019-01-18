package eu.innosoft.androidpoc.features.feed_list

import dagger.Module
import dagger.Provides
import eu.innosoft.androidpoc.di.FeatureScope
import eu.innosoft.androidpoc.usecases.GetAds
import eu.innosoft.androidpoc.usecases.GetAdsImpl
import eu.innosoft.androidpoc.usecases.GetFeeds
import eu.innosoft.androidpoc.usecases.GetFeedsImpl


@Module
class FeedListModule {

    @Provides
    @FeatureScope
    fun provideGetFeeds(getFeeds: GetFeedsImpl): GetFeeds = getFeeds


    @Provides
    @FeatureScope
    fun provideGetAds(getAds: GetAdsImpl): GetAds = getAds

    @Provides
    @FeatureScope
    fun provideViewModel(getFeeds: GetFeeds, getAds: GetAds): FeedListViewModel = FeedListViewModel(getFeeds, getAds)

}