package com.midhunarmid.ecommapp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.midhunarmid.ecommapp.R
import com.midhunarmid.ecommapp.helper.Logger
import com.midhunarmid.ecommapp.helper.reload
import com.midhunarmid.ecommapp.repository.model.ResponseData
import com.midhunarmid.ecommapp.view.adapter.RecyclerViewAdapter
import com.midhunarmid.ecommapp.viewmodel.HomeViewModel

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var viewModel: HomeViewModel
    private var mRecyclerView: RecyclerView? = null
    var mAdapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        mRecyclerView = findViewById(R.id.recyclerView)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.mApiResponseLiveData.observe(this, Observer { value ->
            value?.let {
                mAdapter = RecyclerViewAdapter(this, value)
                mRecyclerView?.layoutManager = LinearLayoutManager(this)
                mRecyclerView?.adapter = mAdapter
                mAdapter?.notifyDataSetChanged()
            }
        })


        viewModel.doGetHomeData()
    }
}