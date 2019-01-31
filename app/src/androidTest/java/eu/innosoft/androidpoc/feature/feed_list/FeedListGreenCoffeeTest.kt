package eu.innosoft.androidpoc.feature.feed_list

import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.mauriciotogneri.greencoffee.GreenCoffeeConfig
import com.mauriciotogneri.greencoffee.GreenCoffeeSteps
import com.mauriciotogneri.greencoffee.GreenCoffeeTest
import com.mauriciotogneri.greencoffee.ScenarioConfig
import com.mauriciotogneri.greencoffee.annotations.Given
import com.mauriciotogneri.greencoffee.annotations.Then
import com.mauriciotogneri.greencoffee.annotations.When
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
import org.junit.runners.Parameterized
import org.mockito.MockitoAnnotations
import javax.inject.Inject


@RunWith(Parameterized::class)
class FeedListGreenCoffeeTest(scenarioConfig: ScenarioConfig) : GreenCoffeeTest(scenarioConfig) {


    @get:Rule
    val testRule: ActivityTestRule<MainView> = ActivityTestRule(MainView::class.java, false, false)


    @Inject
    lateinit var mockApi: Api

    private lateinit var mockAppComponent: MockAppComponent


    companion object {
        @Parameterized.Parameters(name = "{0}")
        @JvmStatic
        fun scenarios(): Iterable<ScenarioConfig> {
            return GreenCoffeeConfig()
                    .withFeatureFromAssets("assets/feedlist.feature")
                    .takeScreenshotOnFail()
                    .scenarios()
        }
    }


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
    fun should_show_feed_detail_after_click_item_in_feed_list() {

        start(GoToFeedDetailFromFeedListTest(mockApi, testRule))

    }

}

class GoToFeedDetailFromFeedListTest(val mockApi: Api, val testRule: ActivityTestRule<MainView>) : GreenCoffeeSteps() {

    @Given("^I am in the list screen$")
    fun iInFeedListScreen() {
        whenever(mockApi.getAds()).thenReturn(Single.just(listOf(
                AdModel(message = "Test Ad", position = 1))))
        whenever(mockApi.getFeeds()).thenReturn(Single.just(listOf(
                FeedModel(message = "Test Feed 1", author = "Tester Nr. 1"),
                FeedModel(message = "Test Feed 2", author = "Tester Nr. 2"),
                FeedModel(message = "Test Feed 3", author = "Tester Nr. 3"),
                FeedModel(message = "Test Feed 4", author = "Tester Nr. 4"),
                FeedModel(message = "Test Feed 5", author = "Tester Nr. 5"),
                FeedModel(message = "Test Feed 6", author = "Tester Nr. 6"),
                FeedModel(message = "Test Feed 7", author = "Tester Nr. 7"))))

        testRule.launchActivity(null)
    }

    @When("^I click a feed cell$")
    fun iClickAFeedCell() {
        loadList {
            clickOnFirstItem()
        }
    }

    @Then("^I see a detail list screen")
    fun iSeADetailListScreen() {
        loadList {
            showFeedDetail()
        }
    }

}
