package eu.innosoft.androidpoc.activities.splash

import dagger.Component
import eu.innosoft.androidpoc.AppComponent
import eu.innosoft.androidpoc.di.ActivityScope

@Component(dependencies = [(AppComponent::class)], modules = [(SplashModule::class)])
@ActivityScope
interface SplashComponent {

    fun inject(splashView: SplashView)

    //expose dependencies to feature scoped graphs

}