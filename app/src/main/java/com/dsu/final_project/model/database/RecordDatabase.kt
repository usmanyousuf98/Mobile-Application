package com.dsu.final_project.model.database

import android.content.Context
import androidx.room.*
import com.dsu.final_project.model.datamodel.Record

@Database(entities = [Record::class], version = 6, exportSchema = false)
abstract class RecordDatabase : RoomDatabase() {
    abstract fun recordDao(): RecordDao

    companion object {
        private var instance: RecordDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): RecordDatabase {
            if (instance == null) instance = Room.databaseBuilder(
                ctx.applicationContext, RecordDatabase::class.java, "record_database"
            )
                .fallbackToDestructiveMigration().build()
            return instance!!
        }



    }
}