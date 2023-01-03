package com.berdakh.contacts.ui.all

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.berdakh.contacts.R
import com.berdakh.contacts.databinding.FragmentContactsFavoritesBinding

class FavoriteContactsFragment: Fragment(R.layout.fragment_contacts_favorites) {
    private lateinit var binding: FragmentContactsFavoritesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactsFavoritesBinding.bind(view)

    }
}