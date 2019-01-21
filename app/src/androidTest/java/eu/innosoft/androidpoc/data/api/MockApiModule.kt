package eu.innosoft.androidpoc.data.api

import dagger.Module
import dagger.Provides
import org.mockito.Mockito
import javax.inject.Singleton

@Module
class MockApiModule {

    @Provides
    @Singleton
    fun provideMockApiModule(): Api = Mockito.mock(Api::class.java)

}