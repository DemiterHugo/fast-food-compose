package com.example.recipes.data.room

import androidx.room.*
import com.example.recipes.data.database.Apple
import com.example.recipes.data.database.Burger
import com.example.recipes.data.database.Pizza
import com.example.recipes.data.database.Sushi

@Dao
interface ItemDao {

    @Transaction
    @Query("SELECT * FROM AppleDB" )
    fun getAllApple(): List<AppleDBWithResultDB>

    @Transaction
    @Query("SELECT * FROM AppleDB WHERE id = :id")
    fun findByIdApple(id: Int): AppleDBWithResultDB

    @Query("SELECT COUNT(id) FROM AppleDB")
    fun applesCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertApples(apples: List<AppleDB>)

    @Update
    fun updateApples(apple: AppleDB)


/*
    @Query("SELECT * FROM Pizza" )
    fun getAllPizza(): List<Pizza>

    @Query("SELECT * FROM Pizza WHERE id = :id")
    fun findByIdPizza(id: Int): Pizza

    @Query("SELECT COUNT(id) FROM Pizza")
    fun pizzasCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPizzas(pizzas: List<Pizza>)

    @Update
    fun updatePizzas(pizza: Pizza)  */

    @Transaction
    @Query("SELECT * FROM BurgerDB" )
    fun getAllBurger(): List<BurgerDB>

    @Query("SELECT * FROM BurgerDB WHERE id = :id")
    fun findByIdBurger(id: Int): BurgerDB

    @Query("SELECT COUNT(id) FROM BurgerDB")
    fun burgersCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBurgers(burgers: List<BurgerDB>)

    @Update
    fun updateBurgers(burger: BurgerDB)

/*
    @Query("SELECT * FROM Sushi" )
    fun getAllSushi(): List<Sushi>

    @Query("SELECT * FROM Sushi WHERE id = :id")
    fun findByIdSushi(id: Int): Sushi

    @Query("SELECT COUNT(id) FROM Sushi")
    fun sushisCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSushis(sushis: List<Sushi>)

    @Update
    fun updatePizzas(sushi: Sushi) */
}