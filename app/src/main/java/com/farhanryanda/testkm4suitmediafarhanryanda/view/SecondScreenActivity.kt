package com.farhanryanda.testkm4suitmediafarhanryanda.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.farhanryanda.testkm4suitmediafarhanryanda.R
import com.farhanryanda.testkm4suitmediafarhanryanda.databinding.ActivityMainBinding
import com.farhanryanda.testkm4suitmediafarhanryanda.databinding.ActivitySecondScreenBinding
import com.farhanryanda.testkm4suitmediafarhanryanda.view.adapter.UserChoosenAdapter
import com.farhanryanda.testkm4suitmediafarhanryanda.viewmodel.UserChooseViewModel
import com.farhanryanda.testkm4suitmediafarhanryanda.viewmodel.UserViewModel

class SecondScreenActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences

    private lateinit var binding: ActivitySecondScreenBinding
    private lateinit var adapter: UserChoosenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        sharedPref = this.getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.tvName.text = sharedPref.getString("name","")
        binding.btnChooseUser.setOnClickListener {
            startActivity(Intent(this,ThirdScreenActivity::class.java))
        }
        showChoosenUser()
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    private fun showChoosenUser() {
        val viewModel = ViewModelProvider(this)[UserChooseViewModel::class.java]
        viewModel.getUser()?.observe(this) {
            if (it != null) {
                binding.tvSelected.text = ""
                binding.rvUser.layoutManager = LinearLayoutManager(
                    this, LinearLayoutManager.VERTICAL, false
                )
                adapter = UserChoosenAdapter(it)
                adapter.notifyDataSetChanged()
                binding.rvUser.adapter = adapter
                binding.rvUser.setHasFixedSize(true)

                adapter.onCardClick = {
                    viewModel.deleteUser(it.id,it.firstName,it.lastName,it.avatar,it.email)
                }
            }
        }

    }
}