package eu.innosoft.androidpoc.feature.feed_list

import androidx.test.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.nhaarman.mockito_kotlin.whenever
import eu.innosoft.androidpoc.App
import eu.innosoft.androidpoc.AppModule
import eu.innosoft.androidpoc.DaggerMockAppComponent
import eu.innosoft.androidpoc.MockAppComponent
import eu.innosoft.androidpoc.activities.app_main.MainView
import eu.innosoft.androidpoc.data.api.Api
import eu.innosoft.androidpoc.data.models.AdModel
import eu.innosoft.androidpoc.data.models.FeedModel
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import javax.inject.Inject

@LargeTest
@RunWith(AndroidJUnit4::class)
class FeedListTest {


    @get:Rule
    val testRule: ActivityTestRule<MainView> = ActivityTestRule(MainView::class.java, false, false)


    @Inject
    lateinit var mockApi: Api

    private lateinit var mockAppComponent: MockAppComponent


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        val app = InstrumentationRegistry.getTargetContext().applicationContext as App
        mockAppComponent = DaggerMockAppComponent.builder()
                .appModule(AppModule(app))
                .build()
        app.setAppComponent(mockAppComponent)
        mockAppComponent.inject(this)
    }

    @Test
    fun simply_run() {
        whenever(mockApi.getAds()).thenReturn(Single.just(listOf(
                AdModel(message = "Test Ad", position = 1))))
        whenever(mockApi.getFeeds()).thenReturn(Single.just(listOf(
                FeedModel(message = "Test Feed 1", author = "Tester Nr. 1"),
                FeedModel(message = "Test Feed 2", author = "Tester Nr. 2"),
                FeedModel(message = "Test Feed 3", author = "Tester Nr. 3"))))

        testRule.launchActivity(null)

        loadList {
            clickOnFirstItem()
        }


    }

}