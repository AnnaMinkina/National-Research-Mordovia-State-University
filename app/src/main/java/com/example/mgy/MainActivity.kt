package com.example.mgy

import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var calendar: CalendarView
    private lateinit var dateView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Инициализация CalendarView и TextView
        calendar = findViewById(R.id.calendar) // Убедитесь, что ID совпадает с вашим layout
        dateView = findViewById(R.id.date_view) // Убедитесь, что ID совпадает с вашим layout

        // Установка слушателя для CalendarView
        calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Форматирование даты в строку
            val date = "$dayOfMonth-${month + 1}-$year"
            // Установка даты в TextView для отображения
            dateView.text = date
        }

        // Обработка оконных отступов
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}