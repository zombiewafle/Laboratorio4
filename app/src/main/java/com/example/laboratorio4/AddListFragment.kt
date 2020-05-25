package com.example.laboratorio4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laboratorio4.User
import com.example.laboratorio4.util

class AddListFragment: ViewModel(){

     val email = MutableLiveData<String>()
     val phonenumber = MutableLiveData<String>()
     val registered = MutableLiveData<Int>()
     val guests = MutableLiveData<Int>()
     val index = MutableLiveData<Int>()
     val name = MutableLiveData<String>()
     val nameList: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
     val rolelist: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
     val people1 = MutableLiveData<MutableList<User>>()


     var listSize = 0
     var people: MutableList<User>


    init{

        people = mutableListOf()
        for (item in util.lista){
            people.add(item)
        }
        listSize = people.size
        index.value = 0
        nameList.value = ""
        rolelist.value = ""
        guests.value = 0
        registered.value = 0
    }


    private fun nextGuest() {
        if (index.value != people.size) {

            name.value = people[index.value!!].name
            email.value = people[index.value!!].phoneNumber
            phonenumber.value = people[index.value!!].email


        }
    }

    fun isAssisting(){
        registered.value = (registered.value)?.plus(1)
        guests.value = (guests.value)?.plus(1)
        nextGuest()

    }

    fun notAssisting(){
        guests.value = (guests.value)?.plus(1)
        nextGuest()
    }

    fun setFirst(){
        nextGuest()
    }

    fun isAssistingLast(){
        registered.value = (registered.value)?.plus(1)
        guests.value = (guests.value)?.plus(1)
    }
    fun notAssistingLast(){
        guests.value = (guests.value)?.plus(1)
    }

    fun addList(person: MutableList<User>){
        people1.value = person
    }
}