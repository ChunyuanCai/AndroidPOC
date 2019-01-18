package eu.innosoft.androidpoc.activities.app_main

import dagger.Component
import eu.innosoft.androidpoc.AppComponent
import eu.innosoft.androidpoc.di.ActivityScope
import eu.innosoft.androidpoc.widgets.ToastFactory
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt

@Component(dependencies = [(AppComponent::class)], modules = [MainViewModule::class])
@ActivityScope
interface MainViewComponent {

    fun inject(mainView: MainView)

    //expose dependencies to feature scoped graphs

    fun exposeToastFactory(): ToastFactory
    fun exposeTapTargetPromptBuilder(): MaterialTapTargetPrompt.Builder

}