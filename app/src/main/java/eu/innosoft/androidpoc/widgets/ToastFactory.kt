package eu.innosoft.androidpoc.widgets

import android.content.Context
import android.widget.Toast

class ToastFactory(private val context: Context) {

    fun getToastLong(message: String) =
            Toast.makeText(context, message, Toast.LENGTH_LONG)


    fun getToastShort(message: String) =
            Toast.makeText(context, message, Toast.LENGTH_SHORT)

}