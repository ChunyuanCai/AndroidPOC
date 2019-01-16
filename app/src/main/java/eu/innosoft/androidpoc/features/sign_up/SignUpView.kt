package eu.innosoft.androidpoc.features.sign_up

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.activities.app_main.MainView
import eu.innosoft.androidpoc.activities.splash.SplashComponent
import eu.innosoft.androidpoc.activities.splash.SplashView

class SignUpView : Fragment() {

    private lateinit var scopeGraph: SignUpComponent

//    @Inject
//    lateinit var toastFactory: ToastFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupScopeGraph((activity as SplashView).splashScope)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.signup_view, container, false)

    override fun onResume() {
        super.onResume()


        Handler().postDelayed(
                { activity?.startActivity(Intent(activity, MainView::class.java)) },
                500
        )
    }

    private fun setupScopeGraph(splashComponent: SplashComponent) {
        scopeGraph = DaggerSignUpComponent.builder()
                .splashComponent(splashComponent)
                .signUpModule(SignUpModule(this))
                .build()
        scopeGraph.inject(this)
    }

}