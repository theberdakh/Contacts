package com.berdakh.contacts.ui.all

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.DialogFragment
import com.berdakh.contacts.R
import com.berdakh.contacts.data.Contact
import com.berdakh.contacts.data.ContactDatabase
import com.berdakh.contacts.databinding.DialogContactAddBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class AddContactDialog: DialogFragment(R.layout.dialog_contact_add) {
    private lateinit var binding: DialogContactAddBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DialogContactAddBinding.bind(view)

        val dao = ContactDatabase.getInstance(requireContext()).getContactDao()
        binding.apply {
            btnAdd.setOnClickListener {
                val name = etName.text.toString()
                val number =etNumber.text.toString()

                if (name.isNotEmpty()&&number.isNotEmpty()){
                    val contact = Contact(
                        name = name,
                        number = number,
                        isFavorite = 0
                    )

                    dao.addContact(contact)
                    onAddSuccess.invoke()
                    dismiss()
                }
                else {
                    if (name.isEmpty()) etName.error = "Name is missing!"
                    if (number.isEmpty()) etNumber.error = "Number is missing!"
                    textChangedListener(etName)
                    textChangedListener(etNumber)

                }
            }
        }
    }

    private fun textChangedListener(et: TextInputEditText) {
        et.doAfterTextChanged {
            et.error = null
        }
    }
    private var onAddSuccess: () -> Unit ={}
    fun setOnAddSuccessListener(onAddSuccess: () -> Unit){
        this.onAddSuccess = onAddSuccess
    }

}