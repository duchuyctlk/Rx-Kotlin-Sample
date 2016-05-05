package ea.huyduc.rxkotlinsample.helpers.matchers

import android.content.res.Resources
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class DrawableMatcher : TypeSafeMatcher<View> {
    private var mExpectedId: Int
    private var mResourceName: String? = null

    constructor(expectedId: Int) : super(View::class.java) {
        mExpectedId = expectedId;
    }

    override fun matchesSafely(target: View): Boolean {
        if (target !is ImageView) {
            return false
        }

        if (mExpectedId < 0) {
            return target.drawable == null
        }

        var resources = target.context.resources
        var expectedDrawable: Drawable? = ContextCompat.getDrawable(target.context, mExpectedId)
        mResourceName = resources.getResourceEntryName(mExpectedId)

        if (expectedDrawable == null || expectedDrawable !is BitmapDrawable ||
                target.drawable !is BitmapDrawable) {
            return false
        }

        var bitmap = (target.drawable as BitmapDrawable).bitmap
        var otherBitmap = expectedDrawable.bitmap
        return bitmap.sameAs(otherBitmap)
    }

    override fun describeTo(description: Description) {
        description.appendText("with drawable from resource id: ")
        description.appendValue(mExpectedId)
        if (mResourceName != null) {
            description.appendText("[")
            description.appendText(mResourceName)
            description.appendText("]")
        }
    }
}
