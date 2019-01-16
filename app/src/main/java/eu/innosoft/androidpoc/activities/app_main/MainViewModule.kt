package eu.innosoft.androidpoc.activities.app_main

import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import eu.innosoft.androidpoc.di.ActivityScope
import eu.innosoft.androidpoc.views.ToastFactory


@Module
class MainViewModule(private val mainView: MainView) {

    @Provides
    @ActivityScope
    fun providesFM(): FragmentManager =
            mainView.supportFragmentManager


    @Provides
    @ActivityScope
    fun provideToastFactory(): ToastFactory = ToastFactory(mainView.applicationContext)


}