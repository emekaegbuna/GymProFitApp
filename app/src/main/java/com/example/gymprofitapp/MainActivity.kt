package com.example.gymprofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gymprofitapp.databinding.ActivityMainBinding
import com.example.gymprofitapp.ui.AccountPrefDialogFragments
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val tex = "helloooo"

        binding.tvMain.text = tex
        //supportFragmentManager.beginTransaction().add(binding.fragmentContainer.id, AccountPrefDialogFragments()).commit()
        AccountPrefDialogFragments().showsDialog

    }


}