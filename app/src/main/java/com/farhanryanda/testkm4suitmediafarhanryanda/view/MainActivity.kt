package com.farhanryanda.testkm4suitmediafarhanryanda.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.farhanryanda.testkm4suitmediafarhanryanda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = this.getSharedPreferences("datauser", Context.MODE_PRIVATE)

        supportActionBar?.hide()

        binding.btnCheck.setOnClickListener {
            val palindrome = binding.edtPolindrome.text.toString()

            if (isPalindromeString(palindrome) == true) {
                Toast.makeText(this, "is Palindrome", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "not Palindrome", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnNext.setOnClickListener {
            val name = binding.edtName.text.toString()
            val save = sharedPref.edit()
            save.putString("name", name)
            save.apply()
            startActivity(Intent(this, SecondScreenActivity::class.java))
        }

    }

    fun isPalindromeString(inputStr: String): Boolean {
        val sb = StringBuilder(inputStr)
        val reverseStr = sb.reverse().toString()
        return inputStr.equals(reverseStr, ignoreCase = true)
    }
}