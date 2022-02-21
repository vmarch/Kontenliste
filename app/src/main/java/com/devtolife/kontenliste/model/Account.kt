package com.devtolife.kontenliste.model

import java.io.Serializable
/**
Created by Volodymyr Marchenko on 19.02.2022.

Create Data Class Account from JSON object:
{
    "_id": "620f76ab92acd373c3c215a2",
    "firstname": "Peters",
    "surname": "Olson",
    "accountName": "Sparkonto",
    "balance": "135,867.78",
    "currency": "EUR",
    "iban": "DE18099479890768564000"
}
*/

data class Account(
    val _id: String,
    val firstname: String,
    val surname: String,
    val accountName: String,
    val balance: String,
    val currency: String,
    val iban: String,
) : Serializable