package lab.main.bounce

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import lab.main.R

class BounceFragment :
	Fragment(R.layout.bounce_fragment) {
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val imageView = view.findViewById<ImageView>(R.id.bounceImageView)
		val button = view.findViewById<Button>(R.id.bounceButton)

		button.setOnClickListener {
			print("hello")
		}
	}
}