package ea.huyduc.rxkotlinsample.helpers.assertions

import android.support.test.espresso.ViewAssertion

import org.junit.Assert.assertTrue

class CustomViewAssertions {
    companion object {
        fun hasVisibility(visibility: Int): ViewAssertion {
            return ViewAssertion { view, noViewFoundException ->
                assertTrue(view.visibility === visibility)
            }
        }
    }
}