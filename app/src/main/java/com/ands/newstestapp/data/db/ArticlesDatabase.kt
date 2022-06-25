package com.ands.newstestapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.ands.newstestapp.data.models.ArticleUi
import com.google.gson.Gson

/**
 * Created by Dad52(Sobolev) on 6/24/2022.
 */
//@Database(entities = [ArticleUi::class], version = 1)
//@TypeConverters(Converters::class)
//abstract class ArticlesDatabase : RoomDatabase() {
//    abstract fun getDao(): Dao
//}
//
//class Converters {
//    @TypeConverter
//    fun fromList(value: List<String>) = Gson().toJson(value)
//
//    @TypeConverter
//    fun toList(value: String) = Gson().fromJson<List<String>>(value)
//}