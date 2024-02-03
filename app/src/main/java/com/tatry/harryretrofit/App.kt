package com.tatry.harryretrofit

import android.app.Application
import androidx.room.Room
import com.tatry.harryretrofit.data.local.database.AppDatabase
import com.tatry.harryretrofit.data.local.migration.MIGRATION_1_2

class App : Application() {

    lateinit var db: AppDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        // в файловой системе бд - нужно создавать миграции при изменениях бд
        db = Room.databaseBuilder(
            this,
//            applicationContext,
            AppDatabase::class.java,
            "db"
        )
            .addMigrations(MIGRATION_1_2)
            .build()

        INSTANCE = this

//        db = Room
//            .inMemoryDatabaseBuilder(
//                this,
//                AppDatabase::class.java
//            ).fallbackToDestructiveMigration() // удаление предыдущей бд при ее обновлении
//            .build()
    }

    // static Java
    companion object {
        // для получения инстанс апп извне (установка только внутри в методе onCreate)
        lateinit var INSTANCE: App
            private set
    }

}