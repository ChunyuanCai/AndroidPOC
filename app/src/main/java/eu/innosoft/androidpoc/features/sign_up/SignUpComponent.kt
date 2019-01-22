package eu.innosoft.androidpoc.features.sign_up

import dagger.Component
import eu.innosoft.androidpoc.activities.splash.SplashComponent
import eu.innosoft.androidpoc.di.FeatureScope

@Component(dependencies = [(SplashComponent::class)], modules = [(SignUpModule::class)])
@FeatureScope
interface SignUpComponent {
    fun inject(view: SignUpView)
}