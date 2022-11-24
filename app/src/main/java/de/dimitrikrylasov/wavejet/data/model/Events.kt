package de.dimitrikrylasov.wavejet.data.model

data class Events(
    val id: Int,
    val name: String,
    val banner: String,
    val entryfee: String,
    val date: String,
    val location: String,
    val minBpm: Int,
    val maxBpm: Int
)
