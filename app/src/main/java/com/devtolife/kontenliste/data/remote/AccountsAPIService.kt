package com.devtolife.kontenliste.data.remote

import com.devtolife.kontenliste.model.Account
import retrofit2.Call
import retrofit2.http.GET

/**
 * This is an interface of Retrofit 2.
 *
 * @author Volodymyr Marchenko, *Created on 19.02.2022*
 *
 * @see Account
 * @see AccountsDataFetcher
 * @constructor Create empty AccountsAPIService
 */
interface AccountsAPIService {
    /**
     * Get accounts list
     *
     * @return it return as callback List of Accounts
     */
    @GET("/getAccounts")
    fun getAccountsList(): Call<List<Account>>
}