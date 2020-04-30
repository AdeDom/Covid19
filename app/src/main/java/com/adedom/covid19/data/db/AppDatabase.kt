package com.adedom.covid19.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adedom.covid19.data.db.entities.Gender
import com.adedom.covid19.data.db.entities.Nation
import com.adedom.covid19.data.db.entities.Province
import com.adedom.covid19.data.db.entities.Today
import com.adedom.covid19.data.db.entities.Sum
import com.adedom.covid19.data.db.entities.Timeline

@Database(
    entities = [Today::class, Gender::class, Nation::class, Province::class, Sum::class, Timeline::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTodayDao(): TodayDao
    abstract fun getSumDao(): SumDao
    abstract fun getTimelineDao(): TimelineDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "Covid19.db"
        ).fallbackToDestructiveMigration().build()
    }

}
