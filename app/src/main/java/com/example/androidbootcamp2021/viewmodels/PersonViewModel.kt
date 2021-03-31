package com.example.androidbootcamp2021.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.androidbootcamp2021.PersonDataClass
import com.example.androidbootcamp2021.database.DatabaseBuilder
import kotlinx.android.synthetic.main.fragment_add_data.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class PersonViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    lateinit var allPersons: LiveData<List<PersonDataClass>>
    private val roomDatabaseBuilder = DatabaseBuilder.getInstance(context)

    init {
        getAllPersonsDetails()
    }

    private fun getAllPersonsDetails() {
        viewModelScope.launch {
            val persons = roomDatabaseBuilder.personDao().getAllPersonsDetails()
            allPersons = persons
        }
    }

    fun addPersonDetails(personDataClass: PersonDataClass) {
        Executors.newSingleThreadExecutor().execute {
            roomDatabaseBuilder.personDao().insertPersonDetails(
                PersonDataClass(
                    personId = personDataClass.personId,
                    personName = personDataClass.personName,
                    personContact = personDataClass.personContact,
                    personAddress = personDataClass.personAddress
                )
            )
        }
    }
}