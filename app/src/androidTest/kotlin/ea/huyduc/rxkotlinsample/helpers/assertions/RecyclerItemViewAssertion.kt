package ea.huyduc.rxkotlinsample.helpers.assertions

import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.PerformException
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.util.HumanReadables
import android.view.View
import android.support.v7.widget.RecyclerView
import ea.huyduc.rxkotlinsample.helpers.interactions.RecyclerViewInteraction

class RecyclerItemViewAssertion<A> : ViewAssertion {

    private var mPosition: Int
    private var mItem: A
    private var mItemViewAssertion: RecyclerViewInteraction.ItemViewAssertion<A>

    constructor(position: Int, item: A, itemViewAssertion: RecyclerViewInteraction.ItemViewAssertion<A>) {
        mPosition = position
        mItem = item
        mItemViewAssertion = itemViewAssertion
    }

    override fun check(view: View?, noViewFoundException: NoMatchingViewException) {
        val recyclerView = view as RecyclerView
        val viewHolderForPosition = recyclerView.findViewHolderForLayoutPosition(mPosition)
        if (viewHolderForPosition === null) {
            throw (PerformException.Builder())
                    .withActionDescription(toString())
                    .withViewDescription(HumanReadables.describe(view))
                    .withCause(IllegalStateException("No view holder at mPosition: " + mPosition))
                    .build()
        } else {
            val viewAtPosition = viewHolderForPosition.itemView
            mItemViewAssertion.check(mItem, viewAtPosition, noViewFoundException)
        }
    }
}
