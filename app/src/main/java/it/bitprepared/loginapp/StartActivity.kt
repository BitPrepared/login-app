package it.bitprepared.loginapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.IOException

class StartActivity : AppCompatActivity() {

    private val scoutList: MutableList<Scout> = mutableListOf()
    private lateinit var buttonLogin: Button
    private lateinit var editName: EditText
    private lateinit var editSurname: EditText
    private lateinit var errorMessage: ViewGroup

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.start_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_reset) {
            resetInputForm()
        }
        return super.onOptionsItemSelected(item)
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        buttonLogin = findViewById(R.id.button_login)
        editName = findViewById(R.id.edit_name)
        editSurname = findViewById(R.id.edit_surname)
        errorMessage = findViewById(R.id.error_message)

        scoutList.addAll(loadJsonFile())

        buttonLogin.setOnClickListener { _ ->
            // Check if name/surname are inside the JSON File
            val result = scoutList.firstOrNull {
                it.isTheSamePerson(editName.text.toString(), editSurname.text.toString())
            }
            if (result == null) {
                showErrorMessage()
            } else {
                openResultActivity(result.sq)
            }
        }
    }

    private fun showErrorMessage() {
        errorMessage.visibility = View.VISIBLE
    }

    private fun openResultActivity(value: String) {
        val intent = Intent(this@StartActivity, ResultActivity::class.java)
        intent.putExtra(KEY_RESULT_SQ, value)
        startActivity(intent)
    }

    private fun resetInputForm() {
        editName.setText("")
        editSurname.setText("")
        errorMessage.visibility = View.GONE
    }

    private fun loadJsonFile(): List<Scout> {
        val scout = mutableListOf<Scout>()

        val inputStream = resources.openRawResource(R.raw.ragazzi)
        val byteArrayOutputStream = ByteArrayOutputStream()

        var ctr: Int
        try {
            ctr = inputStream.read()
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr)
                ctr = inputStream.read()
            }
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        try {
            // Parse the data into JSONObject to get original data in form of json.
            val jObject = JSONObject(byteArrayOutputStream.toString())
            val jObjectResult = jObject.getJSONArray("ragazzi")

            for (i in 0 until jObjectResult.length()) {
                scout.add(Scout(
                        jObjectResult.getJSONObject(i).getString("nome"),
                        jObjectResult.getJSONObject(i).getString("cognome"),
                        jObjectResult.getJSONObject(i).getString("squadriglia")))
            }
        } catch (e: Exception) {
            throw RuntimeException("Failure during JSON Parsing!", e)
        }
        return scout
    }
}
