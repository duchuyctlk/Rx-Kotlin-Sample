package ea.huyduc.rxkotlinsample.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import ea.huyduc.rxkotlinsample.R
import ea.huyduc.rxkotlinsample.rxbus.RxBus

/**
 * Created by huyduc on 4/20/16.
 */
class TopFragment : Fragment() {
    private lateinit var mRxBus: RxBus

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var layout: View = inflater!!.inflate(R.layout.fragment_top, container)
        val btnClick = layout.findViewById(R.id.btn_click)
        btnClick.setOnClickListener {
            if (mRxBus.hasObservers()) {
                mRxBus.send(ClickEvent())
            }
        }
        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRxBus = RxBus.instance
    }

    companion object {
        class ClickEvent {}
    }
}