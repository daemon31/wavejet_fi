package de.dimitrikrylasov.wavejet.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.dimitrikrylasov.wavejet.data.model.Events

class AppRepository {
    private val _events = MutableLiveData<List<Events>>()
    val events: LiveData<List<Events>>
    get() = _events

    suspend fun getData(){

    }
}

