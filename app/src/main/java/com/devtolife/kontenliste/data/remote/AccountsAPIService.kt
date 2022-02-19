package com.devtolife.kontenliste.data.remote

import com.devtolife.kontenliste.model.Account
import retrofit2.Call
import retrofit2.http.GET

interface AccountsAPIService {
    @GET("/getAccounts")
    fun getAccountsList(): Call<List<Account>>
}