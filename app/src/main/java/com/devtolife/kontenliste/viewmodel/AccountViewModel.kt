package com.devtolife.kontenliste.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devtolife.kontenliste.data.repository.AccountRepository
import com.devtolife.kontenliste.model.Account
import kotlinx.coroutines.launch

/**
 * Class of custom ViewModel with LiveData. It using for sending/getting data to/from Data Layer.
 *
 * @author Volodymyr Marchenko, *Created on 19.02.2022*
 *
 * @see AccountRepository
 * @see Account
 *
 * @constructor Create empty AccountViewModel
 */

class AccountViewModel : ViewModel() {
    /** Instance of AccountRepository */
    private var repository: AccountRepository = AccountRepository()

    /** MutableLiveData Accounts list */
    val accountsList: MutableLiveData<List<Account>> = MutableLiveData()

    /** Loading accounts list using CoroutineScope and update [accountsList] */
    fun loadAccountsList() {
        viewModelScope.launch {
            accountsList.postValue(repository.getAccountsList())
        }
    }
}