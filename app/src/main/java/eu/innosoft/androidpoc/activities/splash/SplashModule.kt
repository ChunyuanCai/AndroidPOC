package eu.innosoft.androidpoc.activities.splash

import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import eu.innosoft.androidpoc.di.ActivityScope


@Module
class SplashModule(private val splashView: SplashView) {

    @Provides
    @ActivityScope
    fun providesFM(): FragmentManager =
            splashView.supportFragmentManager

}