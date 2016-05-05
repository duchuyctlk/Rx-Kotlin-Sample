package ea.huyduc.rxkotlinsample.helpers.matchers

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class CompoundDrawablesMatcher : TypeSafeMatcher<View> {
    private var mExpectedId: Int
    private var mResourceName: String? = null

    constructor(expectedId: Int) : super(View::class.java) {
        this.mExpectedId = expectedId
    }

    override fun matchesSafely(target: View): Boolean {
        if (target !is TextView && target !is Button) {
            return false
        }

        var drawables: Array<Drawable?>? =
                if (target is TextView) {
                    target.compoundDrawables
                } else {
                    if (target is Button) {
                        target.compoundDrawables
                    } else {
                        null
                    }
                }
        var resources = target.context.resources
        var expectedDrawable: Drawable? = ContextCompat.getDrawable(target.context, mExpectedId)
        mResourceName = resources.getResourceEntryName(mExpectedId)

        if (expectedDrawable != null && expectedDrawable is BitmapDrawable && drawables != null) {
            for (drawable in drawables) {
                if (drawable != null && drawable is BitmapDrawable) {
                    var bitmap = drawable.bitmap
                    var otherBitmap = expectedDrawable.bitmap
                    return bitmap.sameAs(otherBitmap)
                }
            }
        }

        return false
    }

    override fun describeTo(description: Description) {
        description.appendText("with compound drawables from resource id: ")
        description.appendValue(mExpectedId)
        if (mResourceName != null) {
            description.appendText("[")
            description.appendText(mResourceName)
            description.appendText("]")
        }
    }
}
