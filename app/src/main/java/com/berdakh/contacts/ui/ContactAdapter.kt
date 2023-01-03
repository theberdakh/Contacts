package com.berdakh.contacts.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.berdakh.contacts.R
import com.berdakh.contacts.data.Contact
import com.berdakh.contacts.databinding.ItemContactBinding

class ContactAdapter: Adapter<ContactAdapter.ContactViewHolder>(){

    inner class ContactViewHolder(private val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(contact: Contact){
            binding.apply {
                tvName.text = contact.name
                tvNumber.text = contact.number
            }
        }
    }

    var contacts = mutableListOf<Contact>()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        val binding = ItemContactBinding.bind(view)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int {
       return contacts.size
    }
}