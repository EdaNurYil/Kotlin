package com.example.livedataapp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModelFactory(private val startingNumber : Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityNewModel::class.java)){
            return MainActivityNewModel(startingNumber ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}