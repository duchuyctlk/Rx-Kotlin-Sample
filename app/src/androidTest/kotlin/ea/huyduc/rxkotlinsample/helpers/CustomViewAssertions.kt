package ea.huyduc.rxkotlinsample.helpers

import android.support.test.espresso.ViewAssertion

import junit.framework.Assert.assertTrue

class CustomViewAssertions {
    companion object {
        fun hasVisibility(visibility: Int): ViewAssertion {
            return ViewAssertion { view, noViewFoundException ->
                assertTrue(view.visibility === visibility)
            }
        }
    }
}