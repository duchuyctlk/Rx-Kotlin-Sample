package ea.huyduc.rxkotlinsample

import  ea.huyduc.rxkotlinsample.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.Robolectric
import org.robolectric.RobolectricGradleTestRunner
import org.junit.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21))
class MainActivityUTest {
    @Test
    fun testActivityShouldNotBeNull() {
        val mainActivity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        assertTrue(mainActivity != null)
    }
}
