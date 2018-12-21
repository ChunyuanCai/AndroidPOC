package eu.innosoft.androidpoc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import eu.innosoft.androidpoc.feed_list.adapter.FeedsAdapter
import eu.innosoft.androidpoc.feed_list.models.Ad
import eu.innosoft.androidpoc.feed_list.models.Feed
import kotlinx.android.synthetic.main.activity_main_view.*

class MainView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)
        lsFeeds.setHasFixedSize(true)
        lsFeeds.layoutManager = LinearLayoutManager(this)

        if (lsFeeds.adapter == null) {
            lsFeeds.adapter = FeedsAdapter()
        }

        (lsFeeds.adapter as FeedsAdapter).addFeeds(listOf(
                Ad("ad0"),
                Feed("Good news"),
                Feed("Better news"),
                Feed("Best news"),
                Ad("ad0"),
                Feed("Bad news"),
                Feed("Worse news"),
                Ad("ad1"),
                Feed("Worst news"),
                Ad("ad0")
        ))

    }


}
