package lab.main

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import lab.main.bounce.BounceFragment
import lab.main.controls.ControlsFragment

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val bounceFragment = BounceFragment()
		val controlsFragment = ControlsFragment()
		val buttonToControls = findViewById<Button>(R.id.mainToControlsButton)
		val buttonToBounce = findViewById<Button>(R.id.mainToBounceButton)

		supportFragmentManager.beginTransaction().apply {
			replace(R.id.frameLayout, controlsFragment)
			commit()
		}
		buttonToBounce.visibility = View.GONE

		buttonToBounce.setOnClickListener {
			buttonToBounce.visibility = View.GONE
			buttonToControls.visibility = View.VISIBLE
			supportFragmentManager.beginTransaction().apply {
				replace(R.id.frameLayout, bounceFragment)
				commit()
			}
		}
		buttonToControls.setOnClickListener {
			buttonToBounce.visibility = View.VISIBLE
			buttonToControls.visibility = View.GONE
			supportFragmentManager.beginTransaction().apply {
				replace(R.id.frameLayout, controlsFragment)
				commit()
			}
		}
	}
}