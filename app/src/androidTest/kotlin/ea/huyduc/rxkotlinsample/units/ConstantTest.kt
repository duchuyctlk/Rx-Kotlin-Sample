package ea.huyduc.rxkotlinsample.units

import android.support.test.runner.AndroidJUnit4
import ea.huyduc.rxkotlinsample.utils.Constant
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.assertTrue
import org.junit.Assert.assertNotNull

import java.lang.reflect.InvocationTargetException

@RunWith(AndroidJUnit4::class)
class ConstantTest {
    @Test
    @SuppressWarnings("unchecked")
    fun testPrivateConstructor() {
        var targetException: Throwable? = null

        try {
            val constructor = Constant::class.java.getDeclaredConstructor()
            constructor.isAccessible = true
            constructor.newInstance()
            assertTrue("This line is never reached!", false)
        } catch (e: InvocationTargetException) {
            targetException = e.targetException
        }

        assertNotNull(targetException)
        assertTrue(targetException is InstantiationException)
    }
}
