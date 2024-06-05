package com.example.tickets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson

class Main : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    data class cls(val question: String, val answer: Boolean)
    private var i = 0
    private var correct = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        textView = findViewById(R.id.question)
        imageView = findViewById<ImageView>(R.id.image)
        button1.setOnClickListener{CheckAnswer(true) }
        button2.setOnClickListener{CheckAnswer(false) }
        QuestionsAndAnswers()
        SetQuestion()
    }
    private lateinit var list: List<cls>
    private fun QuestionsAndAnswers() {
        list = listOf(
            cls(getString(R.string.q1),true),
            cls(getString(R.string.q2),false),
            cls(getString(R.string.q3),true),
            cls(getString(R.string.q4),false),
            cls(getString(R.string.q5),false),
        )
    }
    private fun SetQuestion() {
        val current = list[i]
        textView.text = current.question
    }
    private fun CheckAnswer(userAnswer:Boolean) {
        val current = list[i]
        var image : Int
        when (i)
        {

            1 -> {
                image = R.drawable.pic2

            }
            3 -> {
                image = R.drawable.pic3

            }

            else -> image = R.drawable.icon
        }
        imageView.setImageResource(image)

        if (userAnswer == current.answer) {
            correct++
        }
        i++
        if (i<list.size){
            SetQuestion()
        }
        else {
            val dataToJson = Data(correct)
            val json = Gson().toJson(dataToJson)
            val intent = Intent(this,Results::class.java)
            intent.putExtra("correct",json)
            startActivity(intent)
        }
    }

}