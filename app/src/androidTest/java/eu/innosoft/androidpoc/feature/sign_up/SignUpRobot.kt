package eu.innosoft.androidpoc.feature.sign_up

import androidx.test.espresso.matcher.ViewMatchers.withId
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.screen_rebot.PerformRobot


fun loadSignUp(func: SignUpRobot.() -> Unit) = SignUpRobot().apply { func() }

class SignUpRobot : PerformRobot() {

    fun signUp(){
        waitFor(withId(R.id.btnSignIn))
        clickButton(R.id.btnSignIn)
    }


}