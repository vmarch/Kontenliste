package com.devtolife.kontenliste.data.repository

import com.devtolife.kontenliste.data.remote.AccountsDataFetcher
import com.devtolife.kontenliste.model.Account
/**
 * Created by Volodymyr Marchenko on 19.02.2022.
 */
class AccountRepository {

    private val accountsDataFetcher: AccountsDataFetcher = AccountsDataFetcher

    private var listOfAccounts: List<Account> = emptyList()
    suspend fun getAccountsList(): List<Account> {
        listOfAccounts = accountsDataFetcher.getAccounts()
        return listOfAccounts
    }
}