package com.example.kotlin_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var textSecond: EditText
    private lateinit var btnSecond: Button
    companion object {
        const val EXTRA_DATA_NAME = "extra_data_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        textSecond = findViewById(R.id.et_second_main)
        btnSecond = findViewById(R.id.btn_second)

        val desc = intent.getStringExtra("name")
        textSecond.setText(desc)

        btnSecond.setOnClickListener {
            val data = textSecond.text.toString()
            val intent = Intent()
            intent.putExtra(EXTRA_DATA_NAME, data)
            setResult(
                RESULT_OK,
                intent
            )
            finish()
        }
    }
}
