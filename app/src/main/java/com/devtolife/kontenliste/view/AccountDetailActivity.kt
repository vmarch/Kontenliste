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
 * Created by Volodymyr Marchenko on 21.02.2022.
 */
class AccountDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_detail_account)

        val displayMetrics: DisplayMetrics = this.resources.displayMetrics
        val dpWidth: Float = displayMetrics.widthPixels / displayMetrics.density

        // If we used Dialog style.
        // Dialog have own margin left = 16dp and right = 16dp (32dp in sum).
        // So, if we would like to get margins with 24dp both (48dp in sum),
        // we should use: dpWidth - 16.
        this.window.setLayout(
            (((dpWidth - 16) * displayMetrics.density).toInt()),
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        val firstNameTextView: TextView = findViewById(R.id.tvFirstNameValue)
        val surnameTextView: TextView = findViewById(R.id.tvSurnameValue)
        val accountNameTextView: TextView = findViewById(R.id.tvAccountNameValue)
        val currencyTextView: TextView = findViewById(R.id.tvCurrencyValue)
        val balanceTextView: TextView = findViewById(R.id.tvBalanceValue)
        val ibanTextView: TextView = findViewById(R.id.tvIbanValue)
        val buttonBack: MaterialButton = findViewById(R.id.buttonBack)

        intent.apply {
            val item = getSerializableExtra("myItem") as Account
            firstNameTextView.text = item.firstname
            surnameTextView.text = item.surname
            accountNameTextView.text = item.accountName
            currencyTextView.text = item.currency
            balanceTextView.text = item.balance
            ibanTextView.text = item.iban
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }
}
