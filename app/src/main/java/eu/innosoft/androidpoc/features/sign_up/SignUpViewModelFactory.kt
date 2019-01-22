package eu.innosoft.androidpoc.features.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class SignUpViewModelFactory @Inject internal constructor() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            return SignUpViewModel() as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}
