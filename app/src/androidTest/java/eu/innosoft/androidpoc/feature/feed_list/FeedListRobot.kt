package eu.innosoft.androidpoc.feature.feed_list

import eu.innosoft.androidpoc.screen_rebot.PerformRobot


fun loadList(func: FeedListRobot.() -> Unit) = FeedListRobot().apply { func() }

class FeedListRobot : PerformRobot() {


    //  page logic robot goes here e.g. click on item whatever
}