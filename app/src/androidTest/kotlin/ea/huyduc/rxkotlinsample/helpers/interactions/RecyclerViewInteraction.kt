package ea.huyduc.rxkotlinsample.helpers.interactions

import android.support.test.espresso.NoMatchingViewException
import android.view.View
import org.hamcrest.Matcher

import android.support.test.espresso.Espresso.onView;
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import android.support.v7.widget.RecyclerView
import ea.huyduc.rxkotlinsample.helpers.assertions.RecyclerItemViewAssertion

class RecyclerViewInteraction<A> {
    private lateinit var mViewMatcher: Matcher<View>
    private lateinit var mItems: List<A>

    constructor(viewMatcher: Matcher<View>) {
        this.mViewMatcher = viewMatcher
    }

    fun withItems(items: List<A>): RecyclerViewInteraction<A> {
        this.mItems = items
        return this
    }

    fun check(itemViewAssertion: ItemViewAssertion<A>): RecyclerViewInteraction<A> {
        for (i in mItems.indices) {
            onView(mViewMatcher)
                    .perform(scrollToPosition<RecyclerView.ViewHolder>(i))
                    .check(RecyclerItemViewAssertion(i, mItems[i], itemViewAssertion))
        }
        return this
    }

    companion object {
        fun <A> onRecyclerView(viewMatcher: Matcher<View>): RecyclerViewInteraction<A> {
            return RecyclerViewInteraction(viewMatcher)
        }
    }

    interface ItemViewAssertion<A> {
        fun check(item: A, view: View, e: NoMatchingViewException)
    }
}
