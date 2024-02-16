package com.example.poparticlestest.data.Converters

import androidx.room.TypeConverter
import com.example.poparticlestest.main.datasource.entity.MediaMetaData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MediaMetaDataConverters {
    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<MediaMetaData> {
        val gson = Gson()
        if (data == null) {
            return emptyList()
        }
        val listType: Type = object : TypeToken<List<MediaMetaData>>() {}.type
        return gson.fromJson(data, listType)
    }


    @TypeConverter
    fun someObjectListToString(viewed: List<MediaMetaData>): String {
        val gson = Gson()
        return gson.toJson(viewed)
    }

}