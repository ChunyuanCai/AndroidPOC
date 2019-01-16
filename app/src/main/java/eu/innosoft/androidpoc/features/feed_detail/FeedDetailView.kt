package eu.innosoft.androidpoc.features.feed_detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.activities.app_main.MainView
import eu.innosoft.androidpoc.activities.app_main.MainViewComponent
import eu.innosoft.androidpoc.widgets.ToastFactory
import javax.inject.Inject

class FeedDetailView : Fragment() {

    private lateinit var scopeGraph:FeedDetailComponent

    @Inject
    lateinit var toastFactory: ToastFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupScopeGraph((activity as MainView).mainScope)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.feed_details_view, container, false)

    override fun onResume() {
        super.onResume()
        toastFactory.getToastLong("You are in detail now").show()
    }

    private fun setupScopeGraph(mainScope: MainViewComponent) {
        scopeGraph = DaggerFeedDetailComponent.builder()
                .mainViewComponent(mainScope)
                .feedDetailModule(FeedDetailModule(this))
                .build()
        scopeGraph.inject(this)
    }

}