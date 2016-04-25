package ea.huyduc.rxkotlinsample.utils

/**
 * Created by huyduc on 4/20/16.
 */
class Constant private constructor() {
    companion object {
        val TEXT_VIEW_ANIM_DURATION = 400L
        val MAX_ALPHA = 1f
        val MIN_ALPHA = -1f
    }

    init {
        throw InstantiationException("Instances of this type are forbidden.")
    }
}