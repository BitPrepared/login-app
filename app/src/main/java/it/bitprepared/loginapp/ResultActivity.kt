package it.bitprepared.loginapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val KEY_RESULT_SQ = "result_sq"

class ResultActivity : AppCompatActivity() {

    private var resultSq: String? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultSq = if (savedInstanceState == null) {
            intent.extras?.getString(KEY_RESULT_SQ)
        } else {
            savedInstanceState.getSerializable(KEY_RESULT_SQ) as String
        }

        if (resultSq == null) return

        val resultImageView = findViewById<ImageView>(R.id.result_image)
        val resultSqTextView = findViewById<TextView>(R.id.result_sq)

        when (resultSq) {
            RED -> resultImageView.setImageResource(R.drawable.rad1)
            GOLD -> resultImageView.setImageResource(R.drawable.rad3)
            BLUE -> resultImageView.setImageResource(R.drawable.rad2)
            ORANGE -> resultImageView.setImageResource(R.drawable.rad4)
        }
        resultSqTextView.text = resultSq
    }
}
