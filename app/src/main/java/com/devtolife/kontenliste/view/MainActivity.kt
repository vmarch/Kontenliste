package com.devtolife.kontenliste.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devtolife.kontenliste.R
import com.devtolife.kontenliste.model.Account
import com.devtolife.kontenliste.viewmodel.AccountViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var myViewModel: AccountViewModel
    private var accountsList: List<Account> = emptyList()

    private  lateinit var recyclerView: RecyclerView
    private lateinit var customRecyclerViewAdapter: CustomRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProvider(this)[AccountViewModel::class.java]

        recyclerView = findViewById(R.id.recView)
        customRecyclerViewAdapter = CustomRecyclerViewAdapter()

        recyclerView.adapter = customRecyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        myViewModel.loadAccountsList()

        myViewModel.accountsList.observe(this, Observer { dataList ->
            dataList?.let {
                accountsList = it
                customRecyclerViewAdapter.setList(accountsList)
            }
        })
    }
}