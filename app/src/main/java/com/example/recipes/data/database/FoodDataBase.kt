package com.example.recipes.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recipes.data.room.*

@Database(entities = [
    AppleDB::class,
    BurgerDB::class,
    NutritionDB::class,
    NutrientDB::class,
    ResultDB::class,
    //NutritionDBWithNutrientDB::class
                     ], version = 1, exportSchema = false)
abstract class FoodDataBase: RoomDatabase() {

    abstract fun itemDao(): ItemDao
}