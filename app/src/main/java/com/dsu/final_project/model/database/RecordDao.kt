package com.dsu.final_project.model.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dsu.final_project.model.datamodel.Record

@Dao
interface UserDao {
    @Query("SELECT * FROM record")
    suspend fun getAll(): List<Record>

//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<User>
//
//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): User

    @Insert
    suspend fun insertRecord( users: Record)

    @Delete
    suspend fun deleteRecord(user: Record)
}