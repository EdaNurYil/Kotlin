package com.example.livedataapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.livedataapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityNewModel    // ← keep as 'private'
    private lateinit var factory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // ---------- setup ----------
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_main)
        factory  = MainActivityViewModelFactory(200)
        viewModel = ViewModelProvider(this, factory)[MainActivityNewModel::class.java]

        // ---------- handle window insets ----------
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        // ---------- observe LiveData ----------
        viewModel.totalSum.observe(this) { total ->
            binding.resultTXT.text = total.toString()
        }

        // ---------- button click ----------
        binding.button.setOnClickListener {
            viewModel.setTotal(binding.editText.text.toString().toInt())

        }
    }
}
