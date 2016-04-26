package ea.huyduc.rxkotlinsample.fragments

import android.app.Fragment
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ea.huyduc.rxkotlinsample.R
import ea.huyduc.rxkotlinsample.rxbus.RxBus
import ea.huyduc.rxkotlinsample.utils.Constant
import rx.functions.Action1

/**
 * Created by huyduc on 4/20/16.
 */
class BottomFragment : Fragment() {
    private lateinit var mRxBus: RxBus
    private lateinit var mTvClicked: View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var layout: View = inflater!!.inflate(R.layout.fragment_bottom, container)
        mTvClicked = layout.findViewById(R.id.tv_clicked)
        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRxBus = RxBus.instance
        mRxBus.toObservable().subscribe { event ->
            if (event is TopFragment.Companion.ClickEvent) {
                showTextViewClicked()
            }
        }
    }

    private fun showTextViewClicked() {
        mTvClicked.visibility = View.VISIBLE
        mTvClicked.alpha = Constant.MAX_ALPHA
        val viewCompat = ViewCompat.animate(mTvClicked).alphaBy(Constant.MIN_ALPHA)
        viewCompat.duration = Constant.TEXT_VIEW_ANIM_DURATION
    }
}