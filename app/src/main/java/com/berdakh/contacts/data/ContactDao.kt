package com.berdakh.contacts.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {
    @Query("SELECT * from contacts")
    fun getContacts(): List<Contact>

    @Query("SELECT * from contacts WHERE is_favorite =1")
    fun getFavorites(): List<Contact>

    @Insert(entity = Contact::class)
    fun addContact(contact: Contact)

    @Delete(entity = Contact::class)
    fun deleteContact(contact: Contact)

    @Update(entity = Contact::class, onConflict = OnConflictStrategy.REPLACE)
    fun updateContact(contact: Contact)
}