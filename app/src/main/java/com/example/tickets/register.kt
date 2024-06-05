package com.example.tickets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class register : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var pass: EditText
    private lateinit var confirmpass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        login = findViewById(R.id.email);
        pass = findViewById(R.id.password1);
        confirmpass = findViewById(R.id.password2)

    }

    fun next(view: View) {
        if (login.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty() && confirmpass.text.toString().isNotEmpty())
        {
            if (pass.text.toString().length >= 8 && confirmpass.text.toString().length >= 8)
            {
                if (pass.text.toString() == confirmpass.text.toString())
                {
                    val intent = Intent(this,Login::class.java)
                    intent.putExtra("login",login.text.toString())
                    intent.putExtra("password",pass.text.toString())
                    startActivity(intent)
                }
                else
                {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("Неверно!")
                        .setMessage("Пароли не совпадают")
                        .setPositiveButton("Исправить",null)
                        .create()
                        .show()
                }

            }
            else
            {
                val alert = AlertDialog.Builder(this)
                    .setTitle("Неверно!")
                    .setMessage("Пароль должен быть не менее 8 символов")
                    .setPositiveButton("Исправить",null)
                    .create()
                    .show()

            }

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
}