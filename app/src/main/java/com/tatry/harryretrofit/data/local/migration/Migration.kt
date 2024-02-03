package com.tatry.harryretrofit.data.local.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object: Migration(startVersion = 1, endVersion = 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE character ADD COLUMN birthday TEXT")
        // NOT NULL если birthday без String?
    }
}

val MIGRATION_2_3 = object: Migration(startVersion = 2, endVersion = 3) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE character ADD COLUMN hogwarts_house TEXT, image_url TEXT")
    }
}