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
    data class RadianRectContainer(var w:Float,var h:Float) {
        val state = State()
        fun draw(canvas:Canvas,paint:Paint) {
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = Math.min(w,h)/40
            paint.strokeCap = Paint.Cap.ROUND
            canvas.drawRect(w/2-w/4,h/2-w/4,w/2,h/2,0f,360f,paint)
        }
        fun update(stopcb:(Float)->Unit) {
            state.update(stopcb)
        }
        fun startUpdating(startcb:()->Unit) {
            state.startUpdating(startcb)
        }
    }
    data class State(var scale:Float = 0f,var dir:Float = 0f,var prevScale:Float = 0f) {
        fun update(stopcb:(Float)->Unit) {
            scale += 0.1f*dir
            if(Math.abs(scale - prevScale) > 1) {
                scale = prevScale+dir
                dir = 0f
                prevScale = scale
                stopcb(scale)
            }
        }
        fun startUpdating(startcb:()->Unit) {
            if(dir == 0f) {
                dir = 1-2*scale
            }
        }
    }
}
fun Canvas.drawRect(x:Float,y:Float,w:Float,h:Float,start:Float,sweep:Float,paint:Paint) {
    save()
    translate(x+w/2,y+h/2)
    val path = Path()
    path.addArc(RectF(-w/2,-h/2,w/2,h/2),start-45,sweep)
    clipPath(path)
    val rx = Math.min(w,h)/5
    drawRoundRect(RectF(-w/2,-h/2,w/2,h/2),rx,rx,paint)
    restore()
}