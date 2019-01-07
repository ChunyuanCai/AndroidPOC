package eu.innosoft.androidpoc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import eu.innosoft.androidpoc.feed_list.FeedListView

class MainView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_view)
        supportFragmentManager.beginTransaction()
                .replace(R.id.vContainer, FeedListView())
                .commit()
    }


}
