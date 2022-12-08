package de.dimitrikrylasov.wavejet.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import de.dimitrikrylasov.wavejet.data.model.Events
import de.dimitrikrylasov.wavejet.data.model.UserData

@Dao
interface UserDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(event: UserData)

    @Update
    suspend fun update(userData: UserData)

    @Query("SELECT * FROM UserData")
    fun getAll(): LiveData<List<UserData>>

    @Query("SELECT * FROM UserData WHERE id = :id")
    suspend fun getById(id: String): UserData

    @Query("DELETE FROM UserData WHERE id = :id")
    suspend fun deleteById(id: String)
}