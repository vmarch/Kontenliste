package com.devtolife.kontenliste.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devtolife.kontenliste.R
import com.devtolife.kontenliste.model.Account

class CustomRecyclerViewAdapter :
    RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder>() {

    private var dataSet: List<Account> = emptyList()
    fun setList(dataList: List<Account>) {
        dataSet = dataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = dataSet[position]

        holder.textOwnerName.text = item.surname + " " + item.firstname
        holder.textAccount.text = item.accountName
        if(item.balance.replace(",","").toDouble() < 0 ){
            holder.textBalance.setTextColor(Color.RED)
        }else{
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
}