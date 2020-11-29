package com.userdetail.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.userdetail.demo.adapter.ListAdapter
import com.userdetail.demo.data.APIService
import com.mindorks.example.paging.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch



class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    lateinit var mainListAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupList()
        setupView()
    }

    private fun setupView() {
        lifecycleScope.launch {
            viewModel.listData.collect {
                mainListAdapter.submitData(it)
            }
        }
    }

    private fun setupList() {
        mainListAdapter = ListAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mainListAdapter
        }
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun setupViewModel() {
        viewModel =
            ViewModelProvider(
                this,
                ListViewModelFactory(APIService.getApiService())
            )[ListViewModel::class.java]
    }


}