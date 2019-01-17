package eu.innosoft.androidpoc.activities.splash

import androidx.fragment.app.FragmentManager
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