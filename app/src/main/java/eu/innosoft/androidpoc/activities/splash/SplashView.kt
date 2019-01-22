package eu.innosoft.androidpoc.activities.splash

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import eu.innosoft.androidpoc.App
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.features.sign_up.SignUpView
import kotlinx.android.synthetic.main.splash_view.*

class SplashView : AppCompatActivity() {

    val splashScope: SplashComponent by lazy {
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
                {
                    tvWelcome.visibility = View.GONE
                    vSplashContainer.visibility = View.VISIBLE
                    supportFragmentManager.beginTransaction()
                            .add(R.id.vSplashContainer, SignUpView())
                            .commit()
                },
                1500
        )
    }

}
