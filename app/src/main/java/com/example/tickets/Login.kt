package com.example.tickets

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class Login : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var pass: EditText
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login = findViewById(R.id.email);
        pass = findViewById(R.id.password);

        pref = getPreferences(MODE_PRIVATE)
        val ed = pref.edit()
        ed.putString("login", intent.getStringExtra("login"))
        ed.putString("password", intent.getStringExtra("password"))
        ed.apply()



    }

    fun handler(v: View) {
        pref=getPreferences(MODE_PRIVATE)
        if (!(pref.getString("login","") == "" && pref.getString("password","") == ""))
        {
            login.setText(pref.getString("login",""))
            pass.setText(pref.getString("password",""))
            val alert = AlertDialog.Builder(this)
                .setTitle("Успешно")
                .setMessage("Сохранненые данные при регистрации загружены.")
                .setPositiveButton("Продолжить",null)
                .create()
                .show()
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Неверно")
                .setMessage("Данные при регистрации не обнаружены")
                .setPositiveButton("Продолжить",null)
                .create()
                .show()
        }



    }

    fun next(view: View) {
        if (login.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty())
        {
            val intent = Intent(this,Main::class.java)
            startActivity(intent)
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите логин или пароль")
                .setPositiveButton("Продолжить",null)
                .create()
                .show()

        }


    }

    fun toreg(view: View) {
        val intent = Intent(this,register::class.java)
        startActivity(intent)
    }
}