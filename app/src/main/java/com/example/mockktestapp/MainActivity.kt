package com.example.mockktestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mockktestapp.databinding.ActivityProvinceCalcBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityProvinceCalcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_province_calc)
    }
}