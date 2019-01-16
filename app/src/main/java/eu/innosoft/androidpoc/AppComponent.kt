package eu.innosoft.androidpoc

import android.content.Context
import android.content.res.Resources
import dagger.Component
import java.util.*
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(app: App)
    fun exposeAppContext(): Context
    fun exposeResources(): Resources
    fun exposeLocale(): Locale
}