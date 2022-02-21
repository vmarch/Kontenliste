package com.devtolife.kontenliste.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devtolife.kontenliste.R
import com.devtolife.kontenliste.model.Account
import com.devtolife.kontenliste.viewmodel.AccountViewModel

/**
 * Main Activity with RecyclerView for showing list of Accounts
 *
 * @author Volodymyr Marchenko, *Created on 19.02.2022*
 *
 * @see AccountViewModel
 * @see Account
 * @see RecyclerView
 * @see CustomRecyclerViewAdapter
 *
 * @constructor Create empty Main activity
 */
class MainActivity : AppCompatActivity() {

    /** Instance of ViewModel - [AccountViewModel] */
    private lateinit var myViewModel: AccountViewModel

    /** Accounts list */
    private var accountsList: List<Account> = emptyList()

    /** Recycler view */
    private lateinit var recyclerView: RecyclerView

    /** Custom recycler view adapter */
    private lateinit var customRecyclerViewAdapter: CustomRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProvider(this)[AccountViewModel::class.java]

        recyclerView = findViewById(R.id.recView)
        customRecyclerViewAdapter = CustomRecyclerViewAdapter()

        recyclerView.adapter = customRecyclerViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        /** Start loading list of Accounts from [AccountViewModel] */
        myViewModel.loadAccountsList()

        /**
         * Listening of data-changing in list of Accounts in [AccountViewModel]
         * When data changed, then set new list into RecyclerViews Adapter.
         */
        myViewModel.accountsList.observe(this) { dataList ->
            dataList?.let {
                accountsList = it
                customRecyclerViewAdapter.setList(accountsList)
            }
        }
    }
}