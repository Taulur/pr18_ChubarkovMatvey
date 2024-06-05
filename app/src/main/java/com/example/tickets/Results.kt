package com.example.tickets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Results : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        textView = findViewById(R.id.results)

        val correct = intent.getStringExtra("correct")
        val fromjson = Gson().fromJson<Data>(correct,object : TypeToken<Data>() {}.type)

        textView.text = "Ваш результат : \n ${fromjson.correct} / 5 верно"
    }

    fun again(view: View) {
        val intent = Intent(this,Main::class.java)
        startActivity(intent)
    }
}

