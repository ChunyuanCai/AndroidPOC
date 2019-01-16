package eu.innosoft.androidpoc.features.app_splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.features.app_container.MainView

class SplashView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_splash)


        //Normal intent of handling app navigation
        Handler().postDelayed(
                {
                    this.startActivity(Intent(this, MainView::class.java))
                },
                500
        )

    }
}
