package de.dimitrikrylasov.wavejet.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
@Entity
data class Events(
    @PrimaryKey
    val id: Int,
    @Json(name = "name")
    val name: String,
    val banner: String,
    val entryfee: String,
    val date: String,
    val location: String,
    val minBpm: Int,
    val maxBpm: Int
)
