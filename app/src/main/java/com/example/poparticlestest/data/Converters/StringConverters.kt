package com.example.poparticlestest.data.Converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object StringConverter {
    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<String> {
        val gson = Gson()
        if (data == null) {
            return emptyList()
        }
        val listType: Type = object : TypeToken<List<String?>?>() {}.getType()
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(d: List<String?>?): String {
        val gson = Gson()
        return gson.toJson(d)
    }
}