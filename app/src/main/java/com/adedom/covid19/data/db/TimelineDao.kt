package com.adedom.covid19.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adedom.covid19.data.db.entities.Timeline

@Dao
interface TimelineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTimeline(timeline: Timeline)

    @Query("SELECT * FROM timeline")
    fun getTimeline(): LiveData<Timeline>

}
