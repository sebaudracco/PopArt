package com.example.poparticlestest.data.Converters

import androidx.room.TypeConverter
import com.example.poparticlestest.main.datasource.entity.Media
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MediaConverters {
    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Media> {
        val gson = Gson()
        if (data == null) {
            return emptyList()
        }
        val listType: Type = object : TypeToken<List<Media>>() {}.type
        return gson.fromJson(data, listType)
    }


    @TypeConverter
    fun someObjectListToString(viewed: List<Media>): String {
        val gson = Gson()
        return gson.toJson(viewed)
    }

}