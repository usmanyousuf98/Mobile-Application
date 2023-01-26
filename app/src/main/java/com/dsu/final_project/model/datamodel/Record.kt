package com.dsu.final_project.model.datamodel

import androidx.room.ColumnInfo
import  androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Record")
data class Record(
    @PrimaryKey(autoGenerate = true)
    val image:Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "desc") val description:String,
//    var isFav: Boolean
    )
