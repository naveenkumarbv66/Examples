package com.naveen.testing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class Person(val name: String, val age: Int, val city: String, val userImage: String, val id:Int)

class MainViewModel : ViewModel() {

    private val _items = MutableStateFlow<List<Person>>(emptyList())
    val itemsList: StateFlow<List<Person>> = _items.asStateFlow()

    /*init {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                setDefaultValuesForList()
            }
        }
    }*/

    fun setDefaultValuesForList(){
        _items.value = listOf(
            Person("Alice", 31, "London", "https://images.unsplash.com/photo-1529778873920-4da4926a72c2?q=80&w=1036&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",1),
            Person("Bob", 29, "London", "https://images.unsplash.com/photo-1611267254323-4db7b39c732c?q=80&w=986&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 2),
            Person("Charles", 31, "Paris", "https://images.unsplash.com/photo-1615497001839-b0a0eac3274c?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 3),
            Person("Diana", 40, "Paris", "https://plus.unsplash.com/premium_photo-1661676191997-0c0cece2a683?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 4),
            Person("Eve", 29, "London", "https://images.unsplash.com/photo-1598935888738-cd2622bcd437?q=80&w=987&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 5)
        )
    }

    fun restLaitToEmpty(){
        _items.value = mutableListOf()
    }

    fun deleteItem(person: Person){
        _items.update { currentList ->
            currentList.filter { it.id != person.id }
        }
    }
}