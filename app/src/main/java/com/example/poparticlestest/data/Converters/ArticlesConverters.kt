package com.example.poparticlestest.data.Converters

import android.view.View
import androidx.room.TypeConverter
import com.example.poparticlestest.main.datasource.entity.Results
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ArticlesConverters {

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Results> {
        val gson = Gson()
        if (data == null) {
            return emptyList()
        }
        val listType: Type = object : TypeToken<List<Results>>() {}.type
        return gson.fromJson(data, listType)
    }


    @TypeConverter
    fun someObjectListToString(viewed: List<Results>): String {
        val gson = Gson()
        return gson.toJson(viewed)
    }


}
