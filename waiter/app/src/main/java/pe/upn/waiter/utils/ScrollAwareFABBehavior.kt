package pe.upn.waiter.utils

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View


/**
 * Created by brianbritto on 25/06/17.
 */
class ScrollAwareFABBehavior(context: Context?, attrs: AttributeSet?) :
        FloatingActionButton.Behavior(context, attrs) {

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout,
                                     child: FloatingActionButton,
                                     directTargetChild: View, target: View,
                                     nestedScrollAxes: Int): Boolean {

        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL ||
                super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes)

    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout?, child: FloatingActionButton,
                                target: View?, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed,
                dyUnconsumed)

        if (child.visibility == View.VISIBLE) {
            child.hide()
        } else if (child.visibility != View.VISIBLE) {
            child.show()
        }
    }

}
// app:layout_behavior="pe.upn.waiter.utils.ScrollAwareFABBehavior" in fab