package com.example.poparticlestest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.poparticlestest.data.Converters.ArticlesConverters
import com.example.poparticlestest.data.Converters.MediaConverters
import com.example.poparticlestest.data.Converters.MediaMetaDataConverters
import com.example.poparticlestest.data.Converters.StringConverter
import com.example.poparticlestest.data.DAO.ArticlesDao
import com.example.poparticlestest.main.datasource.entity.Media
import com.example.poparticlestest.main.datasource.entity.MediaMetaData
import com.example.poparticlestest.main.datasource.entity.Results
import com.example.poparticlestest.main.datasource.entity.ViewedArticle


@Database(
    entities = [ViewedArticle::class],
    version = 3,
    exportSchema = false
)

@TypeConverters(
    ArticlesConverters::class,
    StringConverter::class,
    MediaConverters::class,
    MediaMetaDataConverters::class
)


abstract class AppDatabase : RoomDatabase() {
    abstract fun articlesDao(): ArticlesDao


    /*companion object {
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "App-Database"
                        ).fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }*/
}