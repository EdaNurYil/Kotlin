package com.example.livedataapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityNewModel(startingNumber: Int) : ViewModel() {

    // Backing property: only the ViewModel can modify this
    private val _total = MutableLiveData(startingNumber)

    // Public‑read, private‑write LiveData
    val totalSum: LiveData<Int>
        get() = _total

    /** Adds [input] to the running total. */
    fun setTotal(input: Int) {
        _total.value = (_total.value ?: 0) + input
    }
}
