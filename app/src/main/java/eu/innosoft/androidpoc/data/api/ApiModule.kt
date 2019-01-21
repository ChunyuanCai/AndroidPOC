package eu.innosoft.androidpoc.data.api

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideApiModule(): Api = ApiServiceImpl()


}