package eu.innosoft.androidpoc.activities.app_main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment.findNavController
import eu.innosoft.androidpoc.App
import eu.innosoft.androidpoc.R
import kotlinx.android.synthetic.main.app_view.*

class MainView : AppCompatActivity() {


    private val mainScope: MainViewComponent by lazy {
        DaggerMainViewComponent.builder()
                .appComponent(App.get(this).getAppComponent())
                .mainViewModule(MainViewModule(this))
                .build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_view)
        mainScope.inject(this)
    }

    override fun onSupportNavigateUp() =
            findNavController(nav_host_fragment).navigateUp()

}
