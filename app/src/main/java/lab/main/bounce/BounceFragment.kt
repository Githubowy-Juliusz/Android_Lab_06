package lab.main.bounce

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import lab.main.R

class BounceFragment(
	private val runOnUiThread: (action: Runnable) -> Unit
) :
	Fragment(
		R.layout.bounce_fragment
	) {
	private val rectWidth = 100
	private val rectHeight = 100
	private val yoffset = 440
	private lateinit var movingThread: MovingThread
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val imageView = view.findViewById<ImageView>(R.id.bounceImageView)
		val button = view.findViewById<Button>(R.id.bounceButton)
		val mover = RectMover(imageView, rectWidth, rectHeight, yoffset)
		movingThread = MovingThread(imageView, 800f, mover, runOnUiThread)
		button.setOnClickListener {
			movingThread.restart()
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		movingThread.stop()
	}
}