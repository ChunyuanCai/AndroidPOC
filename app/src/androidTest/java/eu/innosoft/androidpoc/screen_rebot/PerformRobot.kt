package eu.innosoft.androidpoc.screen_rebot

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import eu.innosoft.androidpoc.features.feed_list.adapter.delegate.FeedDelegateAdapter
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything

/**
 * Consider perform Robot as a util for perform action on view
 */
open class PerformRobot : ScreenRobot() {

    // perform
    fun tapOnText(text: String) {
        waitFor(ViewMatchers.withText(text))
        onView(ViewMatchers.withText(text)).perform(ViewActions.click())
    }

    fun fillEditText(resId: Int, text: String): ViewInteraction =
            onView(withId(resId)).perform(ViewActions.replaceText(text), ViewActions.closeSoftKeyboard())

    fun clickButton(resId: Int): ViewInteraction = onView((withId(resId))).perform(ViewActions.click())

    fun textView(resId: Int): ViewInteraction = onView(withId(resId))

    fun matchText(viewInteraction: ViewInteraction, text: String): ViewInteraction = viewInteraction
            .check(matches(ViewMatchers.withText(text)))

    fun matchText(resId: Int, text: String): ViewInteraction = matchText(textView(resId), text)

    fun clickListItem(listRes: Int, position: Int) {
        onData(anything())
                .inAdapterView(allOf(withId(listRes)))
                .atPosition(position).perform(ViewActions.click())
    }

    fun clickListItemWithText(listRes: Int, text: String) {
        onView(withId(listRes))
                .perform(RecyclerViewActions.actionOnItem<FeedDelegateAdapter.TurnsViewHolder>(
                        hasDescendant(withText(text)), click()))
    }

    //verify
    fun textDisplay(text: String) {
        onView(withText(text)).check(matches(isDisplayed()))
    }


}