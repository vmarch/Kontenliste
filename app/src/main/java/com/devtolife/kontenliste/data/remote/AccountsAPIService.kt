package com.devtolife.kontenliste.data.remote

import com.devtolife.kontenliste.model.Account
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Volodymyr Marchenko on 19.02.2022.
 */
interface AccountsAPIService {
    @GET("/getAccounts")
    fun getAccountsList(): Call<List<Account>>
}