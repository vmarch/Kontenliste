package com.devtolife.kontenliste.view

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devtolife.kontenliste.R
import com.devtolife.kontenliste.model.Account
import java.io.Serializable

/**
 * Custom recycler view adapter
 *
 * @author Volodymyr Marchenko, *Created on 19.02.2022*
 *
 * @see MainActivity - activity where RecyclerView is implemented.
 * @see Account
 * @constructor Create empty Custom recycler view adapter
 */
class CustomRecyclerViewAdapter :
    RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder>() {

    /** List of Accounts */
    private var accountsList: List<Account> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        /**
         * Current Account object from [accountsList] by position.
         * @see accountsList
         */
        val item = accountsList[position]

        /**
         * Set click listener on Item of RecyclerView.
         */
        holder.itemView.setOnClickListener {
            val i = Intent(holder.itemView.context, AccountDetailActivity::class.java)
            i.putExtra("myItem", item as Serializable)
            holder.itemView.context.startActivity(i)
        }
        /** Inflating TextViews with data from current Account object. */
        holder.textOwnerName.text = String.format("%s %s", item.surname, item.firstname)
        holder.textAccount.text = String.format("%s:", item.accountName)
        holder.textBalance.text =  String.format("%s %s", item.balance, item.currency)
        holder.textIban.text = item.iban

        /** Check if current accounts balance lower as 0 and show it in Red or Blue if higher. */
        if (normaliseNumbers(item.balance) < 0) {
            holder.textBalance.setTextColor(Color.RED)
        } else {
            holder.textBalance.setTextColor(Color.BLUE)
        }
    }

    override fun getItemCount(): Int = accountsList.size

    class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        /** Initialise TextView fields of RecyclerView item. */

        /** TextView for firstname and surname owner's of account. */
        val textOwnerName: TextView = v.findViewById(R.id.textViewOwnerName)

        /** TextView for name of account. */
        val textAccount: TextView = v.findViewById(R.id.textViewAccountName)

        /** TextView for balance and currency of account. */
        val textBalance: TextView = v.findViewById(R.id.textViewBalance)

        /** TextView for IBAN of owner of account. */
        val textIban: TextView = v.findViewById(R.id.textViewIbanValue)
    }

    /**
     * Method used for setting list of Accounts in [accountsList] and notifying observer of
     * RecyclerView that data has changed.
     *
     * @param dataList - List of Accounts
     * @see accountsList
     * @see Account
     */
    fun setList(dataList: List<Account>) {
        accountsList = dataList
        notifyDataSetChanged()
    }

    /** Method used for converting the Number from String to Double with deleting commas.
     *
     * !!Because in this API, it gives the balance of user's account with a separation
     * on thousands separated by commas like "135,867.78" */
    private fun normaliseNumbers(itemBalance: String): Double {
        return itemBalance.replace(",", "").toDouble()
    }
}