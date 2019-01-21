package eu.innosoft.androidpoc.screen_rebot

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.util.HumanReadables
import androidx.test.espresso.util.TreeIterables
import org.hamcrest.Matcher
import java.util.concurrent.TimeoutException

/**
 * Screen Robot is implement to handle normal screen wait action
 */
open class ScreenRobot {

    fun waitFor(matcher: Matcher<View>) {
        Espresso.onView(ViewMatchers.isRoot()).perform(waitForMatch(matcher, PATIENCE))
    }

    private fun waitForMatch(matcher: Matcher<View>, millis: Long?): ViewAction {
        return object : ViewAction {

            override fun getConstraints(): Matcher<View> =
                    ViewMatchers.isRoot()

            override fun getDescription(): String = "wait for a specific match using \$matcher during \$millis millis."

            override fun perform(uiController: UiController?, view: View?) {
                uiController?.loopMainThreadUntilIdle()
                val startTime = System.currentTimeMillis()
                val endTime = startTime + millis!!

                do {
                    for (child in TreeIterables.breadthFirstViewTraversal(view)) {
                        // found view with required ID
                        if (matcher.matches(child)) {
                            return
                        }
                    }

                    uiController?.loopMainThreadForAtLeast(50)
                } while (System.currentTimeMillis() < endTime)

                // timeout happens
                throw PerformException.Builder()
                        .withActionDescription(description)
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(TimeoutException())
                        .build()
            }
        }

    }

    companion object {
        const val PATIENCE = 2000L
    }
}
