package lab.main.controls

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import lab.main.R
import lab.main.RectColorizer

class ControlsFragment :
	Fragment(R.layout.controls_fragment) {
	private val rectWidth = 100
	private val rectHeight = 100
	private val yoffset = 440
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val imageView = view.findViewById<ImageView>(R.id.controlsImageView)

		val colorizer = RectColorizer(
			imageView,
			rectWidth,
			rectHeight
		)
		imageView.setOnTouchListener(
			TouchListener(
				rectWidth,
				rectHeight,
				yoffset,
				colorizer
			)
		)
	}
}
