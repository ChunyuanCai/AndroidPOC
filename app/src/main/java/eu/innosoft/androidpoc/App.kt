package eu.innosoft.androidpoc

import android.app.Application
import android.content.Context

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
                .build()
        appComponent.inject(this)
    }
}