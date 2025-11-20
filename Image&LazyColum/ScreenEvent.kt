package com.naveen.testing

// ViewModel file
sealed class ScreenEvent {
    data class onClickItem(val person: Person) : ScreenEvent()
    data class onDeleteItem(val person: Person) : ScreenEvent()
    data class onModifyItem(val person: Person) : ScreenEvent()
}