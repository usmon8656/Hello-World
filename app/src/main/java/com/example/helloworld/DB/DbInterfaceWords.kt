package com.example.helloworld.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.helloworld.Models.User
import com.example.helloworld.Models.UserWords

@Dao
interface DbInterfaceWords {
    @Insert
    fun addWord(userWords: UserWords)

    @Query("select * from userwords")
    fun getAllWords():List<UserWords>

    @Insert
    fun addGroup(user: User)

    @Query("select * from user")
    fun getAllGroups():List<User>
}