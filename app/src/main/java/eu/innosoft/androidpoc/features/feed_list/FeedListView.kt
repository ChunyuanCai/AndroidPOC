package eu.innosoft.androidpoc.features.feed_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import eu.innosoft.androidpoc.R
import eu.innosoft.androidpoc.activities.app_main.MainView
import eu.innosoft.androidpoc.activities.app_main.MainViewComponent
import eu.innosoft.androidpoc.commons.extensions.register
import eu.innosoft.androidpoc.features.feed_list.adapter.FeedsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.feed_list_view.*
import javax.inject.Inject

class FeedListView : Fragment() {

    private lateinit var scopeGraph: FeedListComponent

    private val rxDisposables: CompositeDisposable = CompositeDisposable()

    @Inject
    internal lateinit var viewModel: FeedListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupScopeGraph((activity as MainView).mainScope)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.feed_list_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initList()
    }


    override fun onResume() {
        super.onResume()
        viewModel.getDataForFeedList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { data -> (lsFeeds.adapter as FeedsAdapter).addFeeds(data) }
                .register(rxDisposables)
    }

    override fun onPause() {
        rxDisposables.clear()
        super.onPause()
    }

    private fun initList() {
        lsFeeds.setHasFixedSize(true)
        lsFeeds.layoutManager = LinearLayoutManager(activity)
        if (lsFeeds.adapter == null) {
            lsFeeds.adapter = FeedsAdapter()
        }
    }

    private fun setupScopeGraph(mainScope: MainViewComponent) {
        scopeGraph = DaggerFeedListComponent.builder()
                .mainViewComponent(mainScope)
                .feedListModule(FeedListModule())
                .build()
        scopeGraph.inject(this)
    }
}