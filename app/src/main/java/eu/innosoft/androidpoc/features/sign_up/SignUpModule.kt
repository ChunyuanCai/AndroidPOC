package eu.innosoft.androidpoc.features.sign_up

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import eu.innosoft.androidpoc.di.FeatureScope


@Module
class SignUpModule(private val view: SignUpView) {

    @Provides
    @FeatureScope
    fun provideViewModelFactory(): SignUpViewModelFactory = SignUpViewModelFactory()



    @Provides
    @FeatureScope
    fun provideViewModle(viewModelFactory: SignUpViewModelFactory): SignUpViewModel =
            ViewModelProviders.of(view as Fragment, viewModelFactory).get(SignUpViewModel::class.java)


}