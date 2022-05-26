package com.example.kotlin_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    companion object {
        const val SEND_DATA = "key"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        oneMethod()
    }

    private fun oneMethod() {
        val launcherData =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    Toast.makeText(this, R.string.write_text, Toast.LENGTH_SHORT).show()
                    val data = result.data?.getStringExtra(MainActivity2.EXTRA_DATA_NAME)
                    binding.etMainActivity.setText(data)
                }
            }
        binding.btnSend.setOnClickListener {

            if (binding.etMainActivity.text.trim().isEmpty()) {
                Toast.makeText(this, R.string.write_text, Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra(SEND_DATA, binding.etMainActivity.text.toString())
                launcherData.launch(intent)
            }
        }
    }
}