package de.dimitrikrylasov.wavejet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import de.dimitrikrylasov.wavejet.data.local.EventDatabase
import de.dimitrikrylasov.wavejet.data.model.ApiResponse
import de.dimitrikrylasov.wavejet.data.model.Events
import de.dimitrikrylasov.wavejet.data.remote.EventApi
import retrofit2.http.Tag


const val TAG = "REPOSITORY"

class Repository(
    private val api: EventApi,
    private val database: EventDatabase
) {

    private val _events = MutableLiveData<List<Events>>()
    val events: LiveData<List<Events>>
    get() = _events

    suspend fun getAllEvents() {
        try {
            val result = api.retrofitService.getAllEvents()
            _events.value = result
        } catch (e: Exception){
            println("Error")
        }
    }
}