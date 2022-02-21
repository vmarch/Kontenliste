package com.devtolife.kontenliste.model

import java.io.Serializable

/**

 * Data Class with properties from JSON object:
{
"_id": "620f76ab92acd373c3c215a2",
"firstname": "Peters",
"surname": "Olson",
"accountName": "Sparkonto",
"balance": "135,867.78",
"currency": "EUR",
"iban": "DE18099479890768564000"
}
 * @author Volodymyr Marchenko, *Created on 19.02.2022*
 *
 * @property _id - Identifier of account
 * @property firstname - Firstname of account's Owner
 * @property surname - Surname of account's Owner
 * @property accountName - Name of account
 * @property balance - Balance on account
 * @property currency - Currency of account
 * @property iban - IBAN of account
 *
 * @constructor Create empty Account
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