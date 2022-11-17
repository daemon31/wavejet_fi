package de.syntaxinstitut.myapplication.data

import com.google.firebase.firestore.DocumentId

data class Numbers(
    @DocumentId
    val id: String = "",
    var number: Long = 0,
    var username: String = ""
)

