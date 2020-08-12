package com.adedom.covid19.di

import androidx.room.Room
import com.adedom.covid19.data.db.AppDatabase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataStorageModule  = module {

    single(named("db_name")) { "Covid19.db" }

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, get(named("db_name"))).apply {
            fallbackToDestructiveMigration()
        }.build()
    }

}
