package com.devtolife.kontenliste.view

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.devtolife.kontenliste.R
import com.devtolife.kontenliste.model.Account
import com.google.android.material.button.MaterialButton

/**
 * Activity for showing details of Account that was sent from CustomRecyclerViewAdapter
 * by click on item of list.
 *
 * @author Volodymyr Marchenko, *Created on 20.02.2022*
 *
 * @see CustomRecyclerViewAdapter.onBindViewHolder
 * @constructor Create empty Account detail activity
 */

class AccountDetailActivity : AppCompatActivity() {

    /** Instance of Account */
    private lateinit var item: Account

    /** TextView field for FirstName from current Account object */
    private lateinit var firstNameTextView: TextView

    /** TextView field for Surname from current Account object */
    private lateinit var surnameTextView: TextView

    /** TextView field for Bank accounts name from current Account object */
    private lateinit var accountNameTextView: TextView

    /** TextView field for Currency name from current Account object */
    private lateinit var currencyTextView: TextView

    /** TextView field for Actual balance from current Account object */
    private lateinit var balanceTextView: TextView

    /** TextView field for IBAN from current Account object */
    private lateinit var ibanTextView: TextView

    /** Button used for closing AccountDetailActivity */
    private lateinit var buttonBack: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /** Settings of Activity for using activity without Title in TitleBar. */
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_detail_account)

        /** Getting current DisplayMetrics. */
        val displayMetrics: DisplayMetrics = this.resources.displayMetrics

        /** Calculate current Width of Display in dpi. */
        val dpWidth: Float = displayMetrics.widthPixels / displayMetrics.density

        /**
         * This method sets the size of the activity.
         *
         * If we used Dialog style.
         * Dialog have own margin left = 16dp and right = 16dp (32dp in sum).
         * So, if we would like to get margins with 24dp both (48dp in sum),
         * we should use: dpWidth - 16.
         */
        this.window.setLayout(
            (((dpWidth - 16) * displayMetrics.density).toInt()),
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        /** Initialise views  */
        firstNameTextView = findViewById(R.id.tvFirstNameValue)
        surnameTextView = findViewById(R.id.tvSurnameValue)
        accountNameTextView = findViewById(R.id.tvAccountNameValue)
        currencyTextView = findViewById(R.id.tvCurrencyValue)
        balanceTextView = findViewById(R.id.tvBalanceValue)
        ibanTextView = findViewById(R.id.tvIbanValue)
        buttonBack = findViewById(R.id.buttonBack)

        /**
         * Getting object <b>Account<b> from Intent and set it to [item]
         * @see Account
         */
        intent.apply {
            item = getSerializableExtra("myItem") as Account
        }

        /** Inflating data from current Account to views */
        inflateFields()

        /** Set click listener on button [buttonBack] and close Activity by click */
        buttonBack.setOnClickListener {
            finish()
        }
    }

    /**
     * This method set data from [item] into views of activity.
     *
     * @see Account
     *
     * @see firstNameTextView
     * @see surnameTextView
     * @see accountNameTextView
     * @see currencyTextView
     * @see balanceTextView
     * @see ibanTextView
     */
    private fun inflateFields() {
        firstNameTextView.text = item.firstname
        surnameTextView.text = item.surname
        accountNameTextView.text = item.accountName
        currencyTextView.text = item.currency
        balanceTextView.text = item.balance
        ibanTextView.text = item.iban
    }
}
