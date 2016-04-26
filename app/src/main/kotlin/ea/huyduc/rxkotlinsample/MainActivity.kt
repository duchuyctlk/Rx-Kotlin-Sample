package ea.huyduc.rxkotlinsample

import android.app.KeyguardManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

/**
 * Created by huyduc on 4/20/16.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BuildConfig.DEBUG) {
            val km = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            val keyguardLock = km.newKeyguardLock(MainActivity::class.simpleName)
            keyguardLock.disableKeyguard()
            window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
        }

        setContentView(R.layout.activity_main)
    }
}
