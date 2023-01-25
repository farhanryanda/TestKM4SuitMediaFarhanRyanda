package com.farhanryanda.testkm4suitmediafarhanryanda.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.farhanryanda.testkm4suitmediafarhanryanda.model.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity ORDER BY id ASC")
    fun getDataFavorite(): LiveData<List<UserEntity>>

    @Insert
    fun insertFavorite(movie: UserEntity)

    @Delete
    fun deleteFavorite(movie: UserEntity)
}
