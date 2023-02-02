package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /*
  MENOR QUE 18,5	ABAIXO DO PESO
  ENTRE 18,5 E 24,9 PESO NORMAL
  ENTRE 25,0 E 29,0	EXCESSO DE PESO
  ENTRE 30,0 E 34,9	OBESIDADE CLASSE I
  ENTRE 35,0 E 39,9 OBESIDADE CLASSE II
  MAIOR QUE 40,0	OBSEDIDADE GRAVE
 */

        var classificacao = ""
        if (result < 18.5f) {
            classificacao = "ABAIXODO PESO"
        } else if (result >= 18.5 && result <= 24.9) {
            classificacao = "PESO NORMAL"
        } else if (result >= 25 && result <= 29.9) {
            classificacao = "EXCESSO DE PESO"
        } else if (result >= 30 && result <= 34.9) {
            classificacao = "OBESIDADE CLASSE I"
        } else if (result >= 35 && result <= 39.9) {
            classificacao = "OBESIDADE CLASSE II"
        } else if (result >= 40) {
            classificacao = "OBSEDIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }


}