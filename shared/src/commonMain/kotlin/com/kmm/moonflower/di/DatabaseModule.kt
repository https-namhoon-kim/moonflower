package com.kmm.moonflower.di

import com.kmm.moonflower.core.local.DatabaseDriverFactory
import com.kmm.moonflower.database.AppDatabase
import com.squareup.sqldelight.db.SqlDriver


object DatabaseModule  {

   private lateinit var sqlDriver: SqlDriver

    fun setDB(driver: SqlDriver) {
        sqlDriver = driver
    }

    fun provideAppDatabase() : AppDatabase{
        return AppDatabase(sqlDriver)
    }

}