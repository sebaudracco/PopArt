package com.example.poparticlestest.data.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.poparticlestest.main.datasource.entity.ViewedArticle


@Dao
interface ArticlesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(articles: ViewedArticle)

    @Query("SELECT * FROM ViewedArticle")
    fun getAll() : ViewedArticle

    @Delete
    fun deleteAll(articles: ViewedArticle)

    @Query("DELETE FROM ViewedArticle")
    fun delete()
}