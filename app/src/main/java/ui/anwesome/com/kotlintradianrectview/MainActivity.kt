package ui.anwesome.com.kotlintradianrectview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ui.anwesome.com.radianrectview.RadianRectView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RadianRectView.create(this)
    }
}
