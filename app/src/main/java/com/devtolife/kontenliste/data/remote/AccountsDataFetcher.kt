package com.devtolife.kontenliste.data.remote

import android.util.Log
import com.devtolife.kontenliste.model.Account
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

/** Constant with link to server. */
private const val BASE_URL = "https://bankingapi.free.beeceptor.com"

/** Use BASE_URL2 if BASE_URL is blocked after reaching the limit of 50 connections. */
private const val BASE_URL2 = "https://bankingapipro.free.beeceptor.com"

/**
 * This is the Class of Retrofit 2.
 * It is used for getting list of Accounts
 *
 * @author Volodymyr Marchenko, *Created on 19.02.2022*
 *
 * @see Account
 * @see AccountsAPIService
 * @constructor Create empty AccountsDataFetcher
 */
object AccountsDataFetcher {

    /** Retrofit instance */
    private lateinit var retrofitInstance: Retrofit

    /** Retrofit interface instance */
    private lateinit var accountsAPIService: AccountsAPIService

    /** List of accounts */
    private var listOfAccounts: List<Account> = emptyList()

    /**
     * Getting the list of Accounts from HTTPS API [BASE_URL]
     *
     * @return listOfAccounts the list of Accounts [AccountsDataFetcher.listOfAccounts]
     * @see AccountsAPIService
     */
    suspend fun getAccounts(): List<Account> {

        retrofitInstance = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        /**
         * The Retrofit class generates an implementation of the <b> AccountsAPIService </b> interface.
         */
        accountsAPIService = retrofitInstance.create(AccountsAPIService::class.java)

        val response = accountsAPIService.getAccountsList().awaitResponse()
        if (response.isSuccessful) {
            val data = response.body()!!
            Log.d("TAG", "${data.size}")
            listOfAccounts = data
        } else {
            Log.d("TAG_ERROR", "Response code is: ${response.code()}")
            Log.d("TAG_ERROR", "Response errorBody is: ${response.errorBody()}")
        }

        return listOfAccounts
    }
}