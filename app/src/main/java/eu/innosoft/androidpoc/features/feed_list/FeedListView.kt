package eu.innosoft.androidpoc.features.feed_list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.features.feed_list.adapter.FeedsAdapter
import eu.innosoft.androidpoc.features.feed_list.models.Ad
import eu.innosoft.androidpoc.features.feed_list.models.Feed
import kotlinx.android.synthetic.main.feed_list_view.*

class FeedListView : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.feed_list_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        lsFeeds.setHasFixedSize(true)
        lsFeeds.layoutManager = LinearLayoutManager(activity)

        if (lsFeeds.adapter == null) {
            // bad practice to simply passing a fragment manager for navigation
            // next commit will give a shot on Android Navigator

            lsFeeds.adapter = FeedsAdapter( Navigation.findNavController(view), activity?.supportFragmentManager)
        }

        (lsFeeds.adapter as FeedsAdapter).addFeeds(listOf(
                Ad("Best Ads goes here"),
                Feed("Good news 01"),
                Feed("Better news"),
                Feed("Best news"),
                Ad("Another Ads goes here"),
                Feed("Bad news"),
                Feed("Worse news"),
                Ad("ad1"),
                Feed("Worst news"),
                Ad("ad0")
        ))
    }
}