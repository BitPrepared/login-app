package it.bitprepared.loginapp

import android.os.Build
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
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(KEY_RESULT_SQ, String::class.java)
        } else {
            @Suppress("DEPRECATION")
            savedInstanceState.getSerializable(KEY_RESULT_SQ) as String
        }

        if (resultSq == null) return

        val resultImageView = findViewById<ImageView>(R.id.result_image)
        val resultSqTextView = findViewById<TextView>(R.id.result_sq)

        when {
            resultSq.equals(RED, ignoreCase = true) -> resultImageView.setImageResource(R.drawable.red)
            resultSq.equals(GOLD, ignoreCase = true) -> resultImageView.setImageResource(R.drawable.gold)
            resultSq.equals(BLUE, ignoreCase = true) -> resultImageView.setImageResource(R.drawable.blue)
            resultSq.equals(ORANGE, ignoreCase = true) -> resultImageView.setImageResource(R.drawable.orange)
        }
        resultSqTextView.text = resultSq
    }
}
