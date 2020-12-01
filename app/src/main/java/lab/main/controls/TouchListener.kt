package lab.main.controls

import android.content.res.Resources
import android.view.MotionEvent
import android.view.View
import lab.main.RectColorizer

class TouchListener(
	private val rectWidth: Int,
	private val rectHeight: Int,
	private val yoffset: Int,
	private val colorizer: RectColorizer
) :
	View.OnTouchListener {
	private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
	private val screenHeight = Resources.getSystem().displayMetrics.heightPixels
	override fun onTouch(view: View, event: MotionEvent): Boolean {
		val x = event.rawX.toInt()
		val y = event.rawY.toInt()
		if(event.action == MotionEvent.ACTION_MOVE) {
			var l = x - rectWidth / 2
			var t = y - yoffset - rectHeight / 2
			var r = l + rectWidth
			var b = t + rectHeight
			if(t < 0) {
				t = 0
				b = rectHeight
			}
			if(r > screenWidth) {
				r = screenWidth
				l = r - rectWidth
			}
			if(l < 0) {
				l = 0
				r = rectWidth
			}
			if(b > screenHeight - yoffset) {
				b = screenHeight - yoffset
				t = b - rectHeight
			}
			view.layout(l, t, r, b)
			colorizer.colorize(l, t, r, b)
		}
		return true
	}
}