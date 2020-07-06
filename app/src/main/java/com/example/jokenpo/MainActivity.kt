package com.example.jokenpo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPapel.setOnClickListener {
            tvResult.text = joga(num = 0)
        }
        btnPedra.setOnClickListener {
            tvResult.text = joga(num = 1)
        }
        btnTesoura.setOnClickListener {
            tvResult.text = joga(num = 2)
        }
    }

    private fun joga(num: Int): String {
        ivComp.visibility = View.VISIBLE
        val comp: Int = Random.nextInt(3)
        var end: String = ""
        when (comp) {
            0 -> ivComp.setImageDrawable(getDrawable(R.drawable.papel))
            1 -> ivComp.setImageDrawable(getDrawable(R.drawable.pedra))
            2 -> ivComp.setImageDrawable(getDrawable(R.drawable.tesoura))
        }
        if (comp == num) {
            end = "Empate"
            tvResult.setTextColor(Color.GRAY)
        } else if ((comp == 0 && num == 1) || (comp == 1 && num == 2) || (comp == 2 && num == 0)) {
            end = "Perdeu"
            tvResult.setTextColor(Color.RED)
        } else {
            end = "Ganhou"
            tvResult.setTextColor(Color.GREEN)
        }
        return end
    }
}