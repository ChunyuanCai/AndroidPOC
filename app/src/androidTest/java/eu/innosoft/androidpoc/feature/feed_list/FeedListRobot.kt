package eu.innosoft.androidpoc.feature.feed_list

import androidx.test.espresso.matcher.ViewMatchers.withId
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.screen_rebot.PerformRobot


fun loadList(func: FeedListRobot.() -> Unit) = FeedListRobot().apply { func() }

class FeedListRobot : PerformRobot() {


    //  page logic robot goes here e.g. click on item whatever
    fun clickOnFirstItem(){
        waitFor(withId(R.id.lsFeeds))
        clickListItemWithText(R.id.lsFeeds, "Test Feed 1")
        waitFor(withId(R.id.tvFeedMessage))
    }
}