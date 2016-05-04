package ea.huyduc.rxkotlinsample.integrations

import android.app.Fragment
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import android.support.test.runner.AndroidJUnit4
import android.support.test.rule.ActivityTestRule
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.action.ViewActions.click
import android.view.View

import ea.huyduc.rxkotlinsample.R
import ea.huyduc.rxkotlinsample.MainActivity
import ea.huyduc.rxkotlinsample.fragments.BottomFragment
import ea.huyduc.rxkotlinsample.fragments.TopFragment
import ea.huyduc.rxkotlinsample.helpers.assertions.CustomViewAssertions

import org.junit.Assert.assertTrue

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule @JvmField
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun testUI() {
        assertTrue(findFragmentById(R.id.fragment_top) is TopFragment)
        assertTrue(findFragmentById(R.id.fragment_bottom) is BottomFragment)

        checkViewVisibility(R.id.btn_click, View.VISIBLE)
        checkViewVisibility(R.id.tv_clicked, View.INVISIBLE)
    }

    @Test
    fun clickButton() {
        onView(withId(R.id.btn_click)).perform(click())
        checkViewVisibility(R.id.tv_clicked, View.VISIBLE)
    }

    private fun findFragmentById(id: Int): Fragment {
        val fragment = mActivityRule.activity.fragmentManager.findFragmentById(id)
        assertTrue(fragment != null)
        return fragment
    }

    private fun checkViewVisibility(id: Int, visibility: Int) {
        onView(withId(id)).check(CustomViewAssertions.hasVisibility(visibility))
    }
}
