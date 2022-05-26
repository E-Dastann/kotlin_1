package com.example.kotlin_1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    companion object {
        const val EXTRA_DATA_NAME = "extra_data_name"
        const val SEND_DATA="key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val desc = intent.getStringExtra(SEND_DATA)
        binding.etSecondMain.setText(desc)

        binding.btnSecond.setOnClickListener {
            val data = binding.etSecondMain.text.toString()
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
