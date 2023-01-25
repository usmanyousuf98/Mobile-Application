package com.dsu.final_project.ui.addRecords

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddRecordViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Add Record Fragment"
    }
    val text : LiveData<String> = _text
}