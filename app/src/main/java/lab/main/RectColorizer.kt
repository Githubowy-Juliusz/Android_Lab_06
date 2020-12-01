package lab.main

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView

class RectColorizer(
	imageView: ImageView,
	rectWidth: Int,
	rectHeight: Int
) {
	private val bitmap =
		Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888)
	private val canvas = Canvas(bitmap)
	private val paint = Paint()

	init {
		val arr = IntArray(2)
		imageView.getLocationOnScreen(arr)
		imageView.background = BitmapDrawable(bitmap)
		colorize(arr[0], arr[1], arr[0] + rectWidth, arr[1] + rectHeight)
	}

	fun colorize(left: Int, top: Int, right: Int, bottom: Int) {
		val color =
			(left + (top shl 6) + (right shl 12) + (bottom shl 16)) or 0xFF000000.toInt()
		paint.color = color
		canvas.drawPaint(paint)
	}
}