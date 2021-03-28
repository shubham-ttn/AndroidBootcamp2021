package com.example.androidbootcamp2021.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidbootcamp2021.PersonDataClass
import com.example.androidbootcamp2021.database.DatabaseBuilder
import kotlinx.android.synthetic.main.fragment_add_data.*
import java.util.concurrent.Executors

class PersonViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    var allPersons: LiveData<List<PersonDataClass>> = MutableLiveData()
    private val roomDatabaseBuilder = DatabaseBuilder.getInstance(context)

    init {
        //getAllPersonsDetails()
        allPersons = roomDatabaseBuilder.personDao().getAllPersonsDetails()

    }

//    fun getAllPersonsDetailsObserver(): MutableLiveData<List<PersonDataClass>>  = allPersons

    /*private fun getAllPersonsDetails() {
        Executors.newSingleThreadExecutor().execute {
            val list = roomDatabaseBuilder.personDao().getAllPersonsDetails()
            allPersons.postValue(list)
        }
    }*/

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