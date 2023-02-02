package com.dsu.final_project.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsu.final_project.R
import com.dsu.final_project.model.datamodel.FavouriteRecord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class FavouriteViewModal : ViewModel() {

    private var favRecordList: MutableLiveData<List<FavouriteRecord>> = MutableLiveData()

    fun getAllFavRecords(): LiveData<List<FavouriteRecord>>{
        viewModelScope.launch(Dispatchers.IO ){
            val records = arrayListOf<FavouriteRecord>()
            for(i in 0..10){
                records.add(
                    FavouriteRecord(
                        R.drawable.image_avatar,
                        "Usman",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua" ))

                favRecordList.postValue(records)
            }
        }
        return favRecordList;
    }
}