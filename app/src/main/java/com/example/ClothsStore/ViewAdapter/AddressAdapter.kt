package com.example.ClothsStore.ViewAdapter

import com.example.ClothsStore.userModel.AddressModel
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ClothsStore.R

class AddressAdapter (
    var context: Context,
    var addressModelList: List<AddressModel>,
    var selectedAddress: SelectedAddress
) :
    RecyclerView.Adapter<AddressAdapter.ViewHolder>() {
    private var selectedRadioBtn: RadioButton? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.address_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.address.text = addressModelList[position].userAddress
        holder.radioButton.setOnClickListener { view ->
            for (address in addressModelList) {
                address.isSelected = false
            }
            addressModelList[position].isSelected = true
            if (selectedRadioBtn != null) {
                selectedRadioBtn!!.isChecked = false
            }
            selectedRadioBtn = view as RadioButton
            selectedRadioBtn!!.isChecked = true
            selectedAddress.setAddress(addressModelList[position].userAddress)
        }
    }

    override fun getItemCount(): Int {
        return addressModelList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var address: TextView
        var radioButton: RadioButton

        init {
            address = itemView.findViewById(R.id.address_add)
            radioButton = itemView.findViewById(R.id.select_address)
        }
    }

    interface SelectedAddress {
        fun setAddress(address: String?)
    }
}