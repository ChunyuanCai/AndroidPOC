package eu.innosoft.androidpoc.data.repository

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAdsRepository(repository: AdsPepositoryImpl): AdsRepository = repository


    @Provides
    @Singleton
    fun provideFeedsRepository(repository: FeedRepositoryImpl): FeedsRepository = repository
}