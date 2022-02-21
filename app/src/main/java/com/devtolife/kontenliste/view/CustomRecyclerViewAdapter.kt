package com.devtolife.kontenliste.view

import android.content.Context
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
 * Created by Volodymyr Marchenko on 19.02.2022.
 */
class CustomRecyclerViewAdapter :
    RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder>() {

    lateinit var context: Context
    private var dataSet: List<Account> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = dataSet[position]
        context = holder.itemView.context

        holder.itemView.setOnClickListener {
            val i = Intent(context, AccountDetailActivity::class.java)
            i.putExtra("myItem", item as Serializable)
            context.startActivity(i)
        }

        holder.textOwnerName.text = item.surname + " " + item.firstname
        holder.textAccount.text = item.accountName + ":"
        if (item.balance.replace(",", "").toDouble() < 0) {
            holder.textBalance.setTextColor(Color.RED)
        } else {
            holder.textBalance.setTextColor(Color.BLUE)
        }
        holder.textBalance.text = item.balance + " " + item.currency
        holder.textIban.text = item.iban

    }

    override fun getItemCount(): Int = dataSet.size

    class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val textOwnerName: TextView = v.findViewById(R.id.textViewOwnerName)
        val textAccount: TextView = v.findViewById(R.id.textViewAccountName)
        val textBalance: TextView = v.findViewById(R.id.textViewBalance)
        val textIban: TextView = v.findViewById(R.id.textViewIbanValue)
    }

    fun setList(dataList: List<Account>) {
        dataSet = dataList
        notifyDataSetChanged()
    }
}