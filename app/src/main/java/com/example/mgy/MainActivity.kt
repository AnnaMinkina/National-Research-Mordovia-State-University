package com.example.mgy

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val editTextLogin: EditText by lazy { findViewById(R.id.editText2) }
    private val editTextPassword: EditText by lazy { findViewById(R.id.editText3) }
    private val buttonEnter: Button by lazy { findViewById(R.id.button) }

    private val textWatcherLogin: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(p0: Editable?) {
            checkButtonEnabled(login = p0.toString())
        }
    }

    private val textWatcherPassword: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(p0: Editable?) {
            checkButtonEnabled(password = p0.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.constraint_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView1: ImageView = findViewById(R.id.imageView1)
        imageView1.setOnClickListener {
            imageView1.setBackgroundColor(Color.argb(64, 0, 0, 0))
            imageView1.postDelayed({ imageView1.setBackgroundColor(Color.TRANSPARENT) }, 200)
        }

        val textView2: TextView = findViewById(R.id.textView2)
        textView2.setOnClickListener {
            textView2.setBackgroundColor(Color.argb(64, 0, 0, 0))
            textView2.postDelayed({ textView2.setBackgroundColor(Color.TRANSPARENT) }, 200)
        }

        val imageView2: ImageView = findViewById(R.id.imageView2)
        imageView2.setOnClickListener {
            imageView2.setBackgroundColor(Color.argb(64, 0, 0, 0))
            imageView2.postDelayed({ imageView2.setBackgroundColor(Color.TRANSPARENT) }, 200)
        }

        editTextLogin.addTextChangedListener(textWatcherLogin)
        editTextPassword.addTextChangedListener(textWatcherPassword)
        buttonEnter.setOnClickListener {
            val intent = Intent(this, Authorization::class.java)
            startActivity(intent)
        }
        checkButtonEnabled()
    }

    override fun onDestroy() {
        editTextLogin.removeTextChangedListener(textWatcherLogin)
        editTextPassword.removeTextChangedListener(textWatcherPassword)
        super.onDestroy()
    }

    private fun checkButtonEnabled(
        login: String? = editTextLogin.text.toString(),
        password: String? = editTextPassword.text.toString()
    ) {
        buttonEnter.isEnabled = !login.isNullOrBlank() && !password.isNullOrBlank()
    }
}