package com.example.mytranlatorapp.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.mytranlatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: TranslatorViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.translateResult.observe(this) {
            binding.tvShowResult.text = it
        }


        binding.btGetResult.setOnClickListener {
            val text = binding.etText.text.toString()
            if (text.isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val toText = binding.spinner.selectedItem.toString()
            val to = getLanguage(toText)
            viewModel.getTranslate(text, to!!)
        }
    }

    fun getLanguage(language: String): String? {
        val map = mapOf(
            "Английский" to "en",
            "Немецкий" to "de"
        )
        return map[language]
    }
}