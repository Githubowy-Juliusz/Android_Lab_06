package lab.main.controls

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import lab.main.R

class ControlsFragment :
	Fragment(R.layout.controls_fragment) {
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val imageView = view.findViewById<ImageView>(R.id.controlsImageView)
		val buttonUp = view.findViewById<Button>(R.id.controlsButtonUp)
		val buttonDown = view.findViewById<Button>(R.id.controlsButtonDown)
		val buttonLeft = view.findViewById<Button>(R.id.controlsButtonLeft)
		val buttonRight = view.findViewById<Button>(R.id.controlsButtonRight)
	}
}
