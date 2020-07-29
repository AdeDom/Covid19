package com.adedom.covid19.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adedom.covid19.data.db.entities.*

@Database(
    entities = [Today::class, Gender::class, Nation::class, Province::class, Sum::class, Timeline::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTodayDao(): TodayDao
    abstract fun getSumDao(): SumDao
    abstract fun getTimelineDao(): TimelineDao

}
