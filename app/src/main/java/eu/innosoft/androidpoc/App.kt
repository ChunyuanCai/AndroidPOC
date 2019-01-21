package eu.innosoft.androidpoc

import android.app.Application
import android.content.Context
import eu.innosoft.androidpoc.data.api.ApiModule
import eu.innosoft.androidpoc.data.repository.RepositoryModule

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initComponents()

    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }

    fun setAppComponent(appComponent: AppComponent) {
        this.appComponent = appComponent
    }


    companion object {
        fun get(context: Context): App =
                context.applicationContext as App
    }

    private fun initComponents() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .repositoryModule(RepositoryModule())
                .apiModule(ApiModule())
                .build()
        appComponent.inject(this)
    }

}