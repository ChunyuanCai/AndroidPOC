package eu.innosoft.androidpoc

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import java.util.*


@Module
class AppModule (application: Application){

    private var appContext: Context = application.baseContext

    @Provides
    @Singleton
    fun provideApplication(): Context {
        return appContext
    }

    @Provides
    @Singleton
    fun provideAppResources(): Resources {
        return appContext.getResources()
    }

    @Provides
    @Singleton
    fun provideLocale(): Locale {
        return Locale.getDefault()
    }

}