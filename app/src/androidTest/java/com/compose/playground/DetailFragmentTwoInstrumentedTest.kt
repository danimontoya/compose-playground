package com.compose.playground


import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DetailFragmentTwoInstrumentedTest {

    @get:Rule
    val rule = composeMainActivityTestRule()

    @Test
    fun navigateToDetailFragmentTwo() {
        rule.launch()

        onView(withId(R.id.goToItemsList)).check(matches(isDisplayed()))
        onView(withId(R.id.goToItemsList)).perform(click())

        onView(withId(R.id.itemTwo)).check(matches(isDisplayed()))
        onView(withId(R.id.itemTwo)).perform(click())
        rule.onNodeWithText("Detail item 2").assertIsDisplayed()
    }
}
