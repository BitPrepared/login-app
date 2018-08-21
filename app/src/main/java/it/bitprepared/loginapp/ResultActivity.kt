package it.bitprepared.loginapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

const val KEY_RESULT_SQ = "result_sq"

class ResultActivity : AppCompatActivity() {

    private var resultSq: String? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultSq = if (savedInstanceState == null) {
            intent.extras.getString(KEY_RESULT_SQ)
        } else {
            savedInstanceState.getSerializable(KEY_RESULT_SQ) as String
        }

        if (resultSq == null) return

        when (resultSq) {
            WHITE -> result_image.setImageResource(R.drawable.rad2)
            YELLOW -> result_image.setImageResource(R.drawable.rad5)
            RED -> result_image.setImageResource(R.drawable.rad3)
            GREEN -> result_image.setImageResource(R.drawable.rad4)
        }
        result_sq.text = resultSq
    }
}
