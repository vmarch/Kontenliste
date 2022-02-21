package com.devtolife.kontenliste.data.remote

import android.util.Log
import com.devtolife.kontenliste.model.Account
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Volodymyr Marchenko on 19.02.2022.
 *
 * Use BASE_URL2 if BASE_URL is blocked after reaching the limit of 50 connections
 */
private const val BASE_URL = "https://bankingapi.free.beeceptor.com"
private const val BASE_URL2 = "https://bankingapipro.free.beeceptor.com"

object AccountsDataFetcher {

    private lateinit var retrofitInstance: Retrofit
    private lateinit var accountsAPIService: AccountsAPIService

    private var listOfAccounts: List<Account> = emptyList()

    suspend fun getAccounts(): List<Account> {

        retrofitInstance = Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        accountsAPIService = retrofitInstance.create(AccountsAPIService::class.java)

        val response = accountsAPIService.getAccountsList().awaitResponse()
        if (response.isSuccessful) {
            val data = response.body()!!
            Log.d("TAG", "${data.size}")
            listOfAccounts = data
        }

        return listOfAccounts
    }
}