package ui.anwesome.com.radianrectview

import android.view.*
import android.content.*
import android.graphics.*
/**
 * Created by anweshmishra on 07/01/18.
 */
class RadianRectView(ctx:Context):View(ctx) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas:Canvas) {

    }
    override fun onTouchEvent(event:MotionEvent):Boolean {
        when(event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}