package com.example.whiteboard

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.whiteboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var isArrowIconClicked = false

    companion object {
        var path = Path()
        var paintBrush = Paint()
        var colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        supportActionBar?.hide()

        binding?.apply {
            btnArrow.setOnClickListener {
                isArrowIconClicked = !isArrowIconClicked

                if (isArrowIconClicked) {
                    btnArrow.setImageResource(R.drawable.ic_selected_line)
                    btnArrow.setBackgroundResource(R.drawable.background_cards)


                    drawLine.visibility = View.VISIBLE
                } else {
                    btnArrow.setImageResource(R.drawable.ic_unselected_line)
                    btnArrow.setBackgroundResource(R.drawable.background_card)
                }
            }
        }
    }

    private fun currentColor(color: Int) {
        currentBrush = color
        path = Path()
    }

}