package eu.innosoft.androidpoc.features.feed_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.activities.app_main.MainView
import eu.innosoft.androidpoc.activities.app_main.MainViewComponent
import eu.innosoft.androidpoc.features.feed_list.adapter.FeedsAdapter
import eu.innosoft.androidpoc.features.feed_list.models.Ad
import eu.innosoft.androidpoc.features.feed_list.models.Feed
import kotlinx.android.synthetic.main.feed_list_view.*

class FeedListView : Fragment() {

    private lateinit var scopeGraph: FeedListComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupScopeGraph((activity as MainView).mainScope)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.feed_list_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        lsFeeds.setHasFixedSize(true)
        lsFeeds.layoutManager = LinearLayoutManager(activity)

        if (lsFeeds.adapter == null) {
            lsFeeds.adapter = FeedsAdapter()
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

    private fun setupScopeGraph(mainScope: MainViewComponent) {
        scopeGraph = DaggerFeedListComponent.builder()
                .mainViewComponent(mainScope)
                .feedListModule(FeedListModule(this))
                .build()
        scopeGraph.inject(this)
    }
}