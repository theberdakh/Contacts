package com.berdakh.contacts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.berdakh.contacts.R
import com.berdakh.contacts.databinding.ActivityMainBinding
import com.berdakh.contacts.ui.all.AllContactsFragment
import com.berdakh.contacts.ui.all.FavoriteContactsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, AllContactsFragment())
            .commit()

        binding.apply {
            bnvMain.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.item_all -> {
                        supportFragmentManager.beginTransaction()
                            .add(R.id.fragment_container, AllContactsFragment())
                            .commit()
                    }
                    R.id.item_favorites -> {
                        supportFragmentManager.beginTransaction()
                            .add(R.id.fragment_container, FavoriteContactsFragment())
                            .commit()
                    }

                }
                true
            }
        }
    }
}