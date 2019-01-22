package eu.innosoft.androidpoc.features.sign_up

import androidx.lifecycle.ViewModel
import io.reactivex.Single


enum class SignUpViewResponse {
    goToMainView,
    doNothing
}

class SignUpViewModel : ViewModel() {

    fun getResponse() = Single.just(SignUpViewResponse.goToMainView)

}
