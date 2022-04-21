package com.lymobility.shanglv.widget

import android.content.Context
import android.util.AttributeSet
import kotlin.jvm.JvmOverloads
import android.widget.ScrollView
import android.view.ViewGroup
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.ListView

/**
 * 解决国际航班舱位列表界面滑动冲突
 */
class LbTScrollview @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ScrollView(context, attrs, defStyle) {
    var header: ViewGroup? = null
    var listView: ListView? = null
    var y0 = 0
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> y0 = ev.y.toInt()
            MotionEvent.ACTION_MOVE -> {
                val dy = (ev.y - y0).toInt()
                if (listView == null) listView =
                    (getChildAt(0) as LinearLayout).getChildAt(1) as ListView
                if (dy > 5 && !isHeaderVisible && listView!!.scrollY == 0 || dy < 0 && isHeaderVisible) {
//                    Log.e("test", "y0 ="+y0 +"  y="+ev.getY());
                    return true
                }
            }
            else -> {}
        }
        return super.onInterceptTouchEvent(ev)
    }

    private val isHeaderVisible: Boolean
        private get() {
            if (header == null) header = (getChildAt(0) as LinearLayout).getChildAt(0) as ViewGroup
            return Math.abs(scrollY) < header!!.height
        }
}