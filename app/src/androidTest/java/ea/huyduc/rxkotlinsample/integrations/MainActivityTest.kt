package ea.huyduc.rxkotlinsample.integrations

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import android.support.test.runner.AndroidJUnit4
import android.support.test.rule.ActivityTestRule
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed

import ea.huyduc.rxkotlinsample.R
import ea.huyduc.rxkotlinsample.MainActivity

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule @JvmField
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun testUI() {
        testWidgetIsDisplayed(R.id.fragment_top, R.id.fragment_bottom)
    }

    private fun testWidgetIsDisplayed(vararg ids: Int) {
        for (id in ids) {
            onView(withId(id)).check(matches(isDisplayed()))
        }
    }
}
