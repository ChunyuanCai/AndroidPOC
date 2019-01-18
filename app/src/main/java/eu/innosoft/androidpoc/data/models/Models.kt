package eu.innosoft.androidpoc.data.models

data class FeedModel(val message: String = "", val author: String = "", val vote: Int = 0)

data class AdModel(val message: String = "", val url: String = "", val position: Int = 1)
