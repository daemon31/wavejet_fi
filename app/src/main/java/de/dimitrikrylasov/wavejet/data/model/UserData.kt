package de.dimitrikrylasov.wavejet.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity

data class UserData(
    @PrimaryKey
    val id: String,
    val nickname: String = "name",
    val alter: String = "alter",
    val genre: String = "genre",
    val mich: String = "blabal"
)