package com.compose.playground

import android.content.Intent
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import org.junit.rules.ExternalResource
import org.junit.rules.TestRule

typealias ComposeMainActivityTestRule = AndroidComposeTestRule<LazyMainActivityScenarioRule, MainActivity>

fun composeMainActivityTestRule(): ComposeMainActivityTestRule =
    AndroidComposeTestRule(
        activityRule = LazyMainActivityScenarioRule(),
        activityProvider = {
            error(
                "composeMainActivityTestRule() does not provide an Activity explicitly. Call ComposeMainActivityTestRule.launch() to start the activity instead."
            )
        }
    )

fun ComposeMainActivityTestRule.launch() {
    activityRule.launch()

    waitForIdle()
}

class LazyMainActivityScenarioRule : ExternalResource(), TestRule {

    private var scenario: ActivityScenario<MainActivity>? = null

    override fun before() {
    }

    override fun after() {
        scenario?.close()
    }

    fun launch() {
        if (scenario != null) throw IllegalStateException("Scenario has already been launched!")

        // Use the Intent based launch() function here. The class based activity launch() function
        // interacts with MainActivity.isWrongInstance() in such a way that flags the test
        // run as the wrong instance, killing the activity before the test can even run. The Intent
        // based version does not have this issue.
        scenario = ActivityScenario.launch(
            Intent(
                ApplicationProvider.getApplicationContext(),
                MainActivity::class.java
            )
        )
    }
}
