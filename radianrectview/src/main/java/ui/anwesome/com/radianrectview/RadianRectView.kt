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
fun Canvas.drawRect(canvas:Canvas,paint:Paint,x:Float,y:Float,w:Float,h:Float,start:Float,sweep:Float) {
    canvas.save()
    canvas.translate(x+w/2,y+h/2)
    val path = Path()
    path.addArc(RectF(-w/2,-h/2,w/2,h/2),start-45,sweep)
    canvas.clipPath(path)
    val rx = Math.min(w,h)/5
    canvas.drawRoundRect(RectF(-w/2,-h/2,w/2,h/2),rx,rx,paint)
    canvas.restore()
}