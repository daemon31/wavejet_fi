package de.dimitrikrylasov.wavejet.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.dimitrikrylasov.wavejet.data.model.Events
import de.dimitrikrylasov.wavejet.data.model.UserData

@Database(entities = [Events::class,UserData::class], version = 1)
abstract class EventDatabase : RoomDatabase(){

    abstract val eventDatabaseDao: EventDatabaseDao
    abstract val userDatabaseDao: UserDatabaseDao
}

private lateinit var INSTANCE: EventDatabase

fun getDatabase(context: android.content.Context ):EventDatabase{
    synchronized(EventDatabase::class.java){
        if (!::INSTANCE.isInitialized){
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                EventDatabase::class.java,
                "event_database"
            )
                .build()
        }
    }
    return INSTANCE
}