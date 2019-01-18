package eu.innosoft.androidpoc.commons.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}


fun View.findNavController(): NavController {
    return Navigation.findNavController(this)
}


fun Disposable.register(disposables: CompositeDisposable) {
    disposables.add(this)
}