package com.adedom.covid19.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adedom.covid19.data.db.entities.Today

@Dao
interface TodayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveToday(today: Today)

    @Query("SELECT * FROM today")
    fun getToday(): LiveData<Today>

}
