package eu.innosoft.androidpoc.features.sign_up

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.activities.app_main.MainView
import eu.innosoft.androidpoc.activities.splash.SplashComponent
import eu.innosoft.androidpoc.activities.splash.SplashView
import eu.innosoft.androidpoc.commons.extensions.register
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.signup_view.*
import javax.inject.Inject

class SignUpView : Fragment() {

    private lateinit var scopeGraph: SignUpComponent

    /** Dependency below can not be injected as it is not provided from the splash component. Really good!
     *
     *  @Inject
     *  lateinit var toastFactory: ToastFactory
     *
     *  In order to use it, you could lift the dependency up to global graph instead
     */

    @Inject
    internal lateinit var viewModel: SignUpViewModel

    private val rxDisposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupScopeGraph((activity as SplashView).splashScope)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.signup_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSignIn.setOnClickListener {
            viewModel.getResponse()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { response ->
                        when (response) {
                            SignUpViewResponse.goToMainView -> goToMainView()
                            SignUpViewResponse.doNothing -> {
                            }
                        }
                    }
                    .register(rxDisposables)
        }
    }

    private fun goToMainView() {
        activity?.startActivity(Intent(activity, MainView::class.java))
    }

    private fun setupScopeGraph(splashComponent: SplashComponent) {
        scopeGraph = DaggerSignUpComponent.builder()
                .splashComponent(splashComponent)
                .signUpModule(SignUpModule(this))
                .build()
        scopeGraph.inject(this)
    }

}