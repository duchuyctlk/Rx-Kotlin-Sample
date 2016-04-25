package ea.huyduc.rxkotlinsample.rxbus

import rx.Observable
import rx.subjects.PublishSubject
import rx.subjects.SerializedSubject

/**
 * https://github.com/kaushikgopal/RxJava-Android-Samples/blob/75bdc271af1fb493e646b1794c7a5bdb5369155a/app/src/main/java/com/morihacky/android/rxjava/rxbus/RxBus.java
 */
class RxBus {

    private val mBus = SerializedSubject(PublishSubject.create<Any>())
    private object Holder { val INSTANCE = RxBus() }

    companion object {
        val instance: RxBus by lazy { Holder.INSTANCE }
    }

    fun send(o: Any) {
        mBus.onNext(o)
    }

    fun toObservable(): Observable<Any> {
        return mBus
    }

    fun hasObservers(): Boolean {
        return mBus.hasObservers()
    }
}
