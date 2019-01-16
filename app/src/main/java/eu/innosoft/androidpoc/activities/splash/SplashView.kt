package eu.innosoft.androidpoc.activities.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import eu.innosoft.androidpoc.App
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.activities.app_main.MainView

class SplashView : AppCompatActivity() {

    private val splashScope: SplashComponent by lazy {
        DaggerSplashComponent.builder()
                .appComponent(App.get(this).getAppComponent())
                .splashModule(SplashModule(this))
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_view)
        splashScope.inject(this)

        Handler().postDelayed(
                { this.startActivity(Intent(this, MainView::class.java)) },
                500
        )
    }

}
