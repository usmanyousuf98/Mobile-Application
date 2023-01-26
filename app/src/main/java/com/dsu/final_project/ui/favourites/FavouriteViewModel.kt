package com.dsu.final_project.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsu.final_project.R
import com.dsu.final_project.model.datamodel.Record
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteViewModel: ViewModel() {
    private var recordList :MutableLiveData<List<Record>> = MutableLiveData()

    //    @SuppressLint("SuspiciousIndentation")
    fun getallRecords(): LiveData<List<Record>>{

        viewModelScope.launch ( Dispatchers.IO ){

            val records = arrayListOf<Record>()
            for (i in 0..10){
                if (i%2==0)
                {
                    records.add(Record(R.drawable.ic_baseline_add_24,"Student -$i","Computer science department"))
                }
                else {
                    records.add(
                        Record(
                            R.drawable.ic_baseline_add_24,
                            "Student -$i",
                            "Computer science department",

                        )
                    )

                }
                recordList.postValue(records)
            }
        }
        return recordList
    }
}