package com.midhunarmid.ecommapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.midhunarmid.ecommapp.R
import com.midhunarmid.ecommapp.viewmodel.HomeViewModel

class HomeScreen : AppCompatActivity() {
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.doGetHomeData()
    }
}