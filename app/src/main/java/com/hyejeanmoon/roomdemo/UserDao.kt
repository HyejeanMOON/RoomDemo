package com.hyejeanmoon.roomdemo

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM users_table")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insertUser(users: List<User>)

    @Delete
    suspend fun deleteUser(users: List<User>)

    @Update
    suspend fun updateUser(vararg users: User)

    @Transaction
    suspend fun deleteAllAndInsertUser(users: List<User>) {
        deleteUser(getAll())
        insertUser(users)
    }
}