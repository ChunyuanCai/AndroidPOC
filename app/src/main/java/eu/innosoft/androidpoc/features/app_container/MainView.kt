package eu.innosoft.androidpoc.features.app_container

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment.findNavController
import eu.innosoft.androidpoc.R
import kotlinx.android.synthetic.main.app_view.*

class MainView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_view)

    }

    override fun onSupportNavigateUp() =
            findNavController(nav_host_fragment).navigateUp()

}
