package com.devtolife.kontenliste.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devtolife.kontenliste.data.repository.AccountRepository
import com.devtolife.kontenliste.model.Account
import kotlinx.coroutines.launch

class AccountViewModel : ViewModel() {
    private var repository: AccountRepository = AccountRepository()
    val accountsList: MutableLiveData<List<Account>> = MutableLiveData()

    fun loadAccountsList() {
        viewModelScope.launch {
           accountsList.postValue(repository.getAccountsList())
        }
    }
}