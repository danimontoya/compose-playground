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
class MasterDetailInstrumentedTest {

    @get:Rule
    val rule = composeMainActivityTestRule()

    @Test
    fun navigateThroughDetailItems() {
        rule.launch()

        onView(withId(R.id.itemOne)).check(matches(isDisplayed()))
        onView(withId(R.id.detailItemOne)).check(matches(isDisplayed()))

        onView(withId(R.id.itemTwo)).perform(click())
        rule.onNodeWithText("Detail item 2").assertIsDisplayed()

        onView(withId(R.id.itemThree)).perform(click())
        onView(withId(R.id.detailItemThree)).check(matches(isDisplayed()))
    }
}
