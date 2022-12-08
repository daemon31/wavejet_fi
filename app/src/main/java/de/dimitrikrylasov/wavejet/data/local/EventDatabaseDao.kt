package de.dimitrikrylasov.wavejet.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.dimitrikrylasov.wavejet.data.model.ApiResponse
import de.dimitrikrylasov.wavejet.data.model.Events


@Dao
interface EventDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(event: Events)

    @Query("SELECT * FROM Events")
    fun getAll(): LiveData<List<Events>>

    @Query("SELECT * FROM Events WHERE id = :id")
    fun getById(id: Int): Events

    @Query("DELETE FROM Events WHERE id = :id")
    suspend fun deleteById(id: Int)
}