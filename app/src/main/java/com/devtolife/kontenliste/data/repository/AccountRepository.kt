package com.devtolife.kontenliste.data.repository

import com.devtolife.kontenliste.data.remote.AccountsDataFetcher
import com.devtolife.kontenliste.model.Account

/**
 * This class used for communication between Presentation Layer and Data Layer.
 * Getting AccountsList with help Retrofit2 from Server API and giving it to ViewModel.
 *
 * @author Volodymyr Marchenko, *Created on 19.02.2022*
 *
 * @see AccountsDataFetcher - Retrofit class in Data Layer
 * @see com.devtolife.kontenliste.viewmodel.AccountViewModel - ViewModel in Presentation Layer
 * @constructor Create empty AccountRepository
 */

class AccountRepository {

    /** Instance of retrofit class */
    private val accountsDataFetcher: AccountsDataFetcher = AccountsDataFetcher

    /** List of Accounts */
    private var listOfAccounts: List<Account> = emptyList()

    /**
     * Getting accounts list from retrofit class [AccountsDataFetcher]
     * @see Account
     * @see AccountsDataFetcher
     * @return [listOfAccounts]
     */
    suspend fun getAccountsList(): List<Account> {
        listOfAccounts = accountsDataFetcher.getAccounts()
        return listOfAccounts
    }
}