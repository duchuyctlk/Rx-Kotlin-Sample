package ea.huyduc.rxkotlinsample

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
            window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                    or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD)
        }

        setContentView(R.layout.activity_main)
    }
}
