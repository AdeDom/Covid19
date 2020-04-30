package com.adedom.covid19.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adedom.covid19.data.db.entities.Gender
import com.adedom.covid19.data.db.entities.Nation
import com.adedom.covid19.data.db.entities.Province
import com.adedom.covid19.data.db.entities.Sum

@Dao
interface SumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveGender(gender: Gender)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNation(nation: Nation)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProvince(province: Province)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSum(sum: Sum): Long

    @Query("SELECT * FROM gender")
    fun getGender(): LiveData<Gender>

    @Query("SELECT * FROM nation")
    fun getNation(): LiveData<Nation>

    @Query("SELECT * FROM province")
    fun getProvince(): LiveData<Province>

    @Query("SELECT * FROM sum")
    fun getSum(): LiveData<Sum>

}
