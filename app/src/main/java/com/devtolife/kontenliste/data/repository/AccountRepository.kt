package com.devtolife.kontenliste.data.repository

import com.devtolife.kontenliste.data.remote.AccountsDataFetcher
import com.devtolife.kontenliste.model.Account

class AccountRepository {

    private val accountsDataFetcher: AccountsDataFetcher = AccountsDataFetcher

    private var listOfAccounts: List<Account> = emptyList()
    suspend fun getAccountsList(): List<Account> {
        listOfAccounts = accountsDataFetcher.getAccounts()
        return listOfAccounts
    }
}