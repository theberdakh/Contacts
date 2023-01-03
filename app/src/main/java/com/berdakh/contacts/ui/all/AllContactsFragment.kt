package com.berdakh.contacts.ui.all

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.berdakh.contacts.R
import com.berdakh.contacts.data.ContactDao
import com.berdakh.contacts.data.ContactDatabase
import com.berdakh.contacts.databinding.FragmentContactsAllBinding
import com.berdakh.contacts.ui.ContactAdapter
import com.google.android.material.snackbar.Snackbar

class AllContactsFragment: Fragment(R.layout.fragment_contacts_all) {
    private lateinit var binding: FragmentContactsAllBinding
    private val adapter = ContactAdapter()
    private lateinit var db: ContactDatabase
    private lateinit var contactDao: ContactDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactsAllBinding.bind(view)


        db = ContactDatabase.getInstance(requireContext())
        contactDao = db.getContactDao()

        binding.apply {
            recyclerView.adapter = adapter
            adapter.contacts = contactDao.getContacts().toMutableList()

            fabAddContact.setOnClickListener {
                val dialog = AddContactDialog()
                dialog.show(requireActivity().supportFragmentManager, dialog.tag)

                dialog.setOnAddSuccessListener {
                    adapter.contacts = contactDao.getContacts().toMutableList()

                    Snackbar.make(fabAddContact, "Contact added successfully!", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

}