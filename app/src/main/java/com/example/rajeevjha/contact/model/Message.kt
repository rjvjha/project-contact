package com.example.rajeevjha.contact.model

data class Message(
    val type: Int,
    val senderName: String,
    val text: String,
    val lastUpdated: String
)