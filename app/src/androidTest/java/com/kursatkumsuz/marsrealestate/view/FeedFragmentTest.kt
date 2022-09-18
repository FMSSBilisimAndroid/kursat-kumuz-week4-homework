package com.kursatkumsuz.marsrealestate.view

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.MediumTest
import com.kursatkumsuz.marsrealestate.view.fragment.FeedFragment
import com.kursatkumsuz.marsrealestate.view.fragment.MarsFragmentFactory
import com.kursatkumsuz.marsrealestate.launchFragmentInHiltContainer
import com.kursatkumsuz.marsrealestate.R
import com.kursatkumsuz.marsrealestate.view.fragment.FeedFragmentDirections
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import javax.inject.Inject

@MediumTest
@HiltAndroidTest
class FeedFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var fragmentFactory: MarsFragmentFactory

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun testNavigationFromFeedToCartFragment() {

        val navController = Mockito.mock(NavController::class.java)

        launchFragmentInHiltContainer<FeedFragment>(
            factory = fragmentFactory
        ) {
            Navigation.setViewNavController(requireView(), navController)
        }

        Espresso.onView(ViewMatchers.withId(R.id.cartButton)).perform(click())

        Mockito.verify(navController).navigate(
            FeedFragmentDirections.actionFeedFragmentToCartFragment()
        )

    }
}