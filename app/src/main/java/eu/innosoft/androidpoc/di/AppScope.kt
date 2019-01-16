package eu.innosoft.androidpoc.di

import javax.inject.Scope

/**
 * The scope lives in activity lifecycle
 */
@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope


/**
 * The scope lives in feature lifecycle
 * the related scoped graph lives within the activity scope
 */
@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureScope