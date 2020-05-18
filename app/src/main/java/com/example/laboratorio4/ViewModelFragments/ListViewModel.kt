package com.example.laboratorio4.ViewModelFragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.laboratorio4.Database.PeopleInfo
import com.example.laboratorio4.Database.database
import kotlinx.coroutines.*

class ListViewModel(
    val database: database,
    application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var persona = MutableLiveData<PeopleInfo>()


}

