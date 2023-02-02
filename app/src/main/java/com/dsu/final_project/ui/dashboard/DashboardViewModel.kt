package com.dsu.final_project.ui.dashboard

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsu.final_project.R
import com.dsu.final_project.model.database.RecordDatabase
import com.dsu.final_project.model.datamodel.FavouriteRecord
import com.dsu.final_project.model.datamodel.Record
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DashboardViewModel (private val context: Context): ViewModel() {

    private var RecordList: MutableLiveData<List<Record>> = MutableLiveData()
    fun getAllRecords(): LiveData<List<Record>>{
        viewModelScope.launch(Dispatchers.IO ){


            val db = RecordDatabase.getInstance(context);
            val recordData=db.recordDao().getAll();
            val records = arrayListOf<Record>();
            recordData.forEach {
                records.add(it)
                RecordList.postValue(records)
            }
        }
        return RecordList;
    }

}