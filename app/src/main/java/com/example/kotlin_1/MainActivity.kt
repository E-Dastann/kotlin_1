package com.example.kotlin_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etText: EditText
    private lateinit var btnSend: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSend = findViewById(R.id.btn_send)
        etText = findViewById(R.id.et_main_activity)
        oneMethod()
    }

    private fun oneMethod() {
        val launcherData =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    Toast.makeText(this, "что то пишите !", Toast.LENGTH_SHORT).show()
                    val data = result.data?.getStringExtra(MainActivity2.EXTRA_DATA_NAME)
                    etText.setText(data)
                }
            }
        btnSend.setOnClickListener {
            if (etText.text.trim().isEmpty()) {
                Toast.makeText(this, "что то пишите !", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("name", etText.text.toString())
                launcherData.launch(intent)
            }
        }
    }
}