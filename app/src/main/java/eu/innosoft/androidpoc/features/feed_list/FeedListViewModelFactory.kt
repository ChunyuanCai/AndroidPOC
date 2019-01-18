package eu.innosoft.androidpoc.features.feed_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import eu.innosoft.androidpoc.usecases.GetAds
import eu.innosoft.androidpoc.usecases.GetFeeds
import javax.inject.Inject

/**
 * As we need to pass dependencies into ViewModel, we need to do it via a ViewModelProvider.Factory implementation
 */
class FeedListViewModelFactory @Inject internal constructor(
        private var getFeeds: GetFeeds,
        private var getAds: GetAds
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(FeedListViewModel::class.java)) {
            return FeedListViewModel(getFeeds, getAds) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}